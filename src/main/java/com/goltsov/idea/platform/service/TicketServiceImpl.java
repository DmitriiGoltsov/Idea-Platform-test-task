package com.goltsov.idea.platform.service;

import com.goltsov.idea.platform.filtration.TicketFiltrationCriterion;
import com.goltsov.idea.platform.model.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketServiceImpl implements TicketService {

    private static final Logger LOGGER = Logger.getLogger("Ticket service logger");

    @Override
    public Map<String, Long> getMinFlightTimePerCarrier(List<Ticket> tickets) {
        Map<String, Long> result = new HashMap<>();

        for (var ticket : tickets) {
            String currentCarrier = ticket.getCarrier();
            if (!result.containsKey(currentCarrier)) {
                result.put(currentCarrier, getFlightDuration(ticket));
            } else if (result.containsKey(currentCarrier) && result.get(currentCarrier) > getFlightDuration(ticket)) {
                result.put(currentCarrier, getFlightDuration(ticket));
            }
        }

        return result;
    }

    @Override
    public int getAvgPrice(List<Ticket> tickets) {
        return tickets.stream()
                .map(Ticket::getPrice)
                .reduce(0, Integer::sum) / tickets.size();
    }

    @Override
    public int getMedianPrice(List<Ticket> tickets) {
        var sortedTickets = tickets.stream()
                .map(Ticket::getPrice)
                .sorted(Integer::compare)
                .toList();

        return sortedTickets.get(sortedTickets.size() / 2);
    }

    @Override
    public int getDiffAvgAndMediaPrices(List<Ticket> tickets) {
        int avgPrice = getAvgPrice(tickets);
        int medianPrice = getMedianPrice(tickets);

        return Math.abs(avgPrice - medianPrice);

    }

    @Override
    public List<Ticket> getTicketsByCriteria(List<TicketFiltrationCriterion> criteria, List<Ticket> tickets) {
        if (Objects.isNull(criteria) || criteria.isEmpty()) {
            throw new IllegalArgumentException("Criteria list cannot be empty or null.");
        }

        Predicate<Ticket> combinedPredicate = makeCombinedPredicate(criteria);

        return tickets.stream()
                .filter(combinedPredicate)
                .toList();
    }

    private static long getFlightDuration(Ticket ticket) {
        String departureString = ticket.getDepartureDate() + 'T' + ticket.getDepartureTime();
        String arrivalString = ticket.getArrivalDate() + 'T' + ticket.getArrivalTime();

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendOptional(DateTimeFormatter.ofPattern("dd.MM.yy'T'HH:mm"))
                .appendOptional(DateTimeFormatter.ofPattern("dd.MM.yy'T'H:mm"))
                .toFormatter();

        LocalDateTime departure = LocalDateTime.parse(departureString, formatter);
        LocalDateTime arrival = LocalDateTime.parse(arrivalString, formatter);

        return Duration.between(departure, arrival).toMinutes();
    }

    private Predicate<Ticket> makeCombinedPredicate(List<TicketFiltrationCriterion> criteria) {
        try {
            return criteria.stream()
                    .map(TicketFiltrationCriterion::getPredicate)
                    .reduce(Predicate::and)
                    .orElse(predicate -> true);
        } catch (NullPointerException e) {
            LOGGER.log(Level.INFO, "Exception occurred during making a combined predicated", e);
            throw new IllegalArgumentException("Criteria contains at least one null");
        }
    }
}
