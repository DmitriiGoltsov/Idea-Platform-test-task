package com.goltsov.idea.platform.test.unit;

import com.goltsov.idea.platform.filtration.OriginAndDestinationFilter;
import com.goltsov.idea.platform.filtration.TicketFiltrationCriterion;
import com.goltsov.idea.platform.mapping.Parser;
import com.goltsov.idea.platform.model.Ticket;
import com.goltsov.idea.platform.service.TicketService;
import com.goltsov.idea.platform.service.TicketServiceImpl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.goltsov.idea.platform.model.Carrier.SU;
import static com.goltsov.idea.platform.model.Carrier.S7;
import static com.goltsov.idea.platform.model.Carrier.BA;
import static com.goltsov.idea.platform.model.Carrier.TK;
import static org.assertj.core.api.Assertions.assertThat;


public class TicketServiceTest {

    private static final String FILE_PATH = "src/test/resources/tickets_for_tests.json";

    private static final String CITY1 = "Владивосток";

    private static final String CITY2 = "Тель-Авив";
    private TicketService ticketService;
    private List<Ticket> tickets;

    @BeforeEach
    void beforeEach() throws IOException {
        tickets = Parser.getData(new File(FILE_PATH));

        ticketService = new TicketServiceImpl();
    }

    @Test
    void getMinFlightTimePerCarrierTest() {
        Map<String, Long> actualResult = ticketService.getMinFlightTimePerCarrier(tickets);

        assertThat(actualResult).containsKeys(S7.toString(), SU.toString(), BA.toString(), TK.toString());
        assertThat(actualResult).containsValues(150L, 390L, 100L, 485L);
        assertThat(actualResult.get(SU.toString())).isEqualTo(100L);
        assertThat(actualResult.get(TK.toString())).isEqualTo(150L);
        assertThat(actualResult.get(S7.toString())).isEqualTo(390L);
        assertThat(actualResult.get(BA.toString())).isEqualTo(485L);
    }

    @Test
    void getTicketsByCriteriaTest() {
        TicketFiltrationCriterion criterion = new OriginAndDestinationFilter(CITY1, CITY2);
        List<Ticket> actualTickets = ticketService.getTicketsByCriteria(List.of(criterion), tickets);

        assertThat(actualTickets).hasSize(10);
    }

    @Test
    void getDiffAvgAndMediaPrices() {

        int actual = ticketService.getDiffAvgAndMediaPrices(tickets);

        assertThat(actual).isEqualTo(1400);
    }
}
