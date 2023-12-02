import controller.TicketController;
import dto.IssueTicketRequestDTO;
import dto.IssueTicketResponseDTO;
import models.ParkingLot;
import models.VehicleType;
import repository.*;
import service.InitialisationService;
import service.TicketService;

public class Main {
    private InitialisationService initialisationService;
    private TicketController ticketController;
    private ParkingLotRepository parkingLotRepository;
    public Main() {
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        GateRepository gateRepository = new GateRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        this.initialisationService = new InitialisationService(gateRepository,parkingFloorRepository,parkingLotRepository,parkingSpotRepository);
        this.ticketController = new TicketController(new TicketService(ticketRepository,parkingLotRepository,gateRepository));

    }

    public static void main(String[] args) {
        Main main = new Main();
        ParkingLot parkingLot =  main.initialisationService.initialise();
        IssueTicketRequestDTO issueTicketRequestDTO = new IssueTicketRequestDTO(
                VehicleType.Four_Wheeler,"ABCD1234","Black",1,"Mercedez");
        IssueTicketResponseDTO responseDTO = main.ticketController.getTicket(issueTicketRequestDTO);
        System.out.println(responseDTO);

        //TODO: Bill generation, given a ticket and gateId, generate a bill
    }
}
