package com.goltsov.idea.platform.service;

import com.goltsov.idea.platform.filtration.TicketFiltrationCriterion;
import com.goltsov.idea.platform.model.Carrier;
import com.goltsov.idea.platform.model.Ticket;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public interface TicketService {

    Map<Carrier, Long> getMinFlightTimePerCarrier(List<Ticket> tickets);

    int getDiffAvgAndMediaPrices(List<Ticket> tickets);

    List<Ticket> getTicketsByCriteria(List<TicketFiltrationCriterion> criteria, List<Ticket> tickets);

    int getMedianPrice(List<Ticket> tickets);

    int getAvgPrice(List<Ticket> tickets);

    Predicate<Ticket> makeCombinedPredicate(List<TicketFiltrationCriterion> criteria);

    long getFlightDuration(Ticket ticket);
}
