package com.goltsov.idea.platform.service;

import com.goltsov.idea.platform.filtration.TicketFiltrationCriterion;
import com.goltsov.idea.platform.model.Ticket;

import java.util.List;
import java.util.Map;

public interface TicketService {

    Map<String, Long> getMinFlightTimePerCarrier(List<Ticket> tickets);

    int getDiffAvgAndMediaPrices(List<Ticket> tickets);

    List<Ticket> getTicketsByCriteria(List<TicketFiltrationCriterion> criteria, List<Ticket> tickets);

    int getMedianPrice(List<Ticket> tickets);

    int getAvgPrice(List<Ticket> tickets);
}
