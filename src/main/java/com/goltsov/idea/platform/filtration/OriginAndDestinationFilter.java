package com.goltsov.idea.platform.filtration;

import com.goltsov.idea.platform.model.Ticket;

import java.util.function.Predicate;

public class OriginAndDestinationFilter implements TicketFiltrationCriterion {

    private final String departureCity;
    private final String destinationCity;

    public OriginAndDestinationFilter(String departureCity, String destinationCity) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
    }

    @Override
    public Predicate<Ticket> getPredicate() {
        return ticket -> ticket.getOriginName().equals(departureCity)
                && ticket.getDestinationName().equals(destinationCity);
    }
}
