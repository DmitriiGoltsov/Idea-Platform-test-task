package com.goltsov.idea.platform.mapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goltsov.idea.platform.model.Ticket;

import java.util.List;

public class TicketWrapper {

    @JsonProperty("tickets")
    private List<Ticket> tickets;

    public List<Ticket> getTickets() {
        return tickets;
    }
}
