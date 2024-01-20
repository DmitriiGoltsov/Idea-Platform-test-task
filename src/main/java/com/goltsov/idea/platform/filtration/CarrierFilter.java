package com.goltsov.idea.platform.filtration;

import com.goltsov.idea.platform.model.Ticket;

import java.util.function.Predicate;

public class CarrierFilter implements TicketFiltrationCriterion {

    private final String carrier;

    public CarrierFilter(String carrier) {
        this.carrier = carrier;
    }

    @Override
    public Predicate<Ticket> getPredicate() {
        return ticket -> ticket.getCarrier().equals(carrier);
    }
}
