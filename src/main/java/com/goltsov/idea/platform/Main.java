package com.goltsov.idea.platform;

import com.goltsov.idea.platform.filtration.OriginAndDestinationFilter;
import com.goltsov.idea.platform.model.Carrier;
import com.goltsov.idea.platform.model.Ticket;
import com.goltsov.idea.platform.mapping.Parser;
import com.goltsov.idea.platform.service.TicketService;
import com.goltsov.idea.platform.service.TicketServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger("Main logger");
    private static final String DEFAULT_FILE_PATH = "src/main/resources/tickets.json";
    private static final String CITY1 = "Владивосток";
    private static final String CITY2 = "Тель-Авив";

    public static void main(String[] args) {

        File file = new File(DEFAULT_FILE_PATH);

        List<Ticket> tickets;
        try {
            tickets = Parser.getData(file);
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Could not map data to a java object", e);
            throw new IllegalArgumentException();
        }

        TicketService ticketService = new TicketServiceImpl();

        List<Ticket> filteredTickets = ticketService.getTicketsByCriteria(List.of(
                new OriginAndDestinationFilter(CITY1, CITY2)), tickets);

        Map<Carrier, Long> minFlightTime = ticketService.getMinFlightTimePerCarrier(filteredTickets);

        minFlightTime.forEach((key, value) ->
                System.out.println("Для компании " + key + " минимальное время перелёта между городами "
                + CITY1 + " и " + CITY2 + " составляет " + value + " минут."));


        System.out.println("\nРазница между средней арифметической и медианной ценой авиабилетов составляет: "
                + ticketService.getDiffAvgAndMediaPrices(filteredTickets) + " рублей.");
    }
}
