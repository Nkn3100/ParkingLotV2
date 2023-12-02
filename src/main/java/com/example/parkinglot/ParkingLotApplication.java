package com.example.parkinglot;

import command.*;
import controller.ParkingLotController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSlotRepository;
import repository.TicketRepository;
import service.ParkingLotService;

import java.util.Scanner;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ParkingLotApplication implements CommandLineRunner {
	private Scanner scanner = new Scanner(System.in);
	ParkingLotController parkingLotController;
	private CommandExecutor commandExecutor;


	public void initialize(){
		ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
		TicketRepository ticketRepository = new TicketRepository();
		ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
		ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
		parkingLotController = new ParkingLotController(new ParkingLotService(parkingSlotRepository,
				parkingFloorRepository, parkingLotRepository,ticketRepository));
		commandExecutor = new CommandExecutor();
		CreateParkingLot createParkingLot = new CreateParkingLot();
		ParkVehicle parkVehicle = new ParkVehicle();
		FreeCount freeCount = new FreeCount();
		GetSlots getSlots = new GetSlots();
		UnPark unPark = new UnPark();
		commandExecutor.addCommand(createParkingLot);
		commandExecutor.addCommand(parkVehicle);
		commandExecutor.addCommand(freeCount);
		commandExecutor.addCommand(getSlots);
		commandExecutor.addCommand(unPark);
	}

	public static void main(String[] args) {
		SpringApplication.run(ParkingLotApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {

			initialize();
			boolean exitCheck = false;
			while(!exitCheck){
				try {
					while (scanner.hasNextLine()) {
						String input = scanner.nextLine();
						if (input.isEmpty()) {
							throw new Exception("Please enter valid command instead of empty line! Java is smarter than you!");
						}
						if (input.contains("exit")) {
							exitCheck = true;
							throw new Exception("Application ended. Rerun the program to continue");
						}
						commandExecutor.execute(input, parkingLotController);
					}
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		 System.exit(0);
	}


}
