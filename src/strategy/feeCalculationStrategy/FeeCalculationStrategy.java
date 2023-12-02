package strategy.feeCalculationStrategy;

import models.Ticket;

public interface FeeCalculationStrategy {
    long getFeeAmount(Ticket ticket);
}
