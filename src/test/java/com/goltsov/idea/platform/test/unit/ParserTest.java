package com.goltsov.idea.platform.test.unit;

import com.goltsov.idea.platform.exception.UnsupportedFileOrFormat;
import com.goltsov.idea.platform.mapping.Parser;
import com.goltsov.idea.platform.model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.goltsov.idea.platform.model.Carrier.SU;
import static com.goltsov.idea.platform.model.Carrier.TK;
import static com.goltsov.idea.platform.model.Carrier.BA;
import static com.goltsov.idea.platform.model.Carrier.S7;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {

    private static final String FILE_PATH = "src/test/resources/tickets_for_tests.json";
    private static final String EMPTY_FILE_PATH = "src/test/resources/empty_json.json";
    private static final String WRONG_FILE_PATH = "src/test/resources/file.txt";

    private File emptyFile;

    private File wrongFile;

    private File testFile;

    private List<Ticket> expectedTickets;

    @BeforeEach
    void beforeEach() {
        testFile = new File(FILE_PATH);
        emptyFile = new File(EMPTY_FILE_PATH);
        wrongFile = new File(WRONG_FILE_PATH);

        expectedTickets = new ArrayList<>();
        expectedTickets.add(new Ticket().setOrigin("VVO").setOriginName("Владивосток").setDestination("TLV")
                .setDestinationName("Тель-Авив").setDepartureDate("12.05.18").setDepartureTime("16:20")
                .setArrivalDate("12.05.18").setArrivalTime("22:10").setCarrier(TK).setStops(3).setPrice(12400));

        expectedTickets.add(new Ticket().setOrigin("VVO").setOriginName("Владивосток").setDestination("TLV")
                .setDestinationName("Тель-Авив").setDepartureDate("12.05.18").setDepartureTime("17:20")
                .setArrivalDate("12.05.18").setArrivalTime("23:50").setCarrier(S7).setStops(1).setPrice(13100));

        expectedTickets.add(new Ticket().setOrigin("VVO").setOriginName("Владивосток").setDestination("TLV")
                .setDestinationName("Тель-Авив").setDepartureDate("12.05.18").setDepartureTime("12:10")
                .setArrivalDate("12.05.18").setArrivalTime("18:10").setCarrier(SU).setStops(0).setPrice(15300));

        expectedTickets.add(new Ticket().setOrigin("VVO").setOriginName("Владивосток").setDestination("TLV")
                .setDestinationName("Тель-Авив").setDepartureDate("12.05.18").setDepartureTime("17:00")
                .setArrivalDate("12.05.18").setArrivalTime("23:30").setCarrier(TK).setStops(2).setPrice(11000));

        expectedTickets.add(new Ticket().setOrigin("VVO").setOriginName("Владивосток").setDestination("TLV")
                .setDestinationName("Тель-Авив").setDepartureDate("12.05.18").setDepartureTime("12:10")
                .setArrivalDate("12.05.18").setArrivalTime("20:15").setCarrier(BA).setStops(3).setPrice(13400));

        expectedTickets.add(new Ticket().setOrigin("VVO").setOriginName("Владивосток").setDestination("TLV")
                .setDestinationName("Тель-Авив").setDepartureDate("12.05.18").setDepartureTime("9:40")
                .setArrivalDate("12.05.18").setArrivalTime("19:25").setCarrier(SU).setStops(3).setPrice(12450));

        expectedTickets.add(new Ticket().setOrigin("VVO").setOriginName("Владивосток").setDestination("TLV")
                .setDestinationName("Тель-Авив").setDepartureDate("12.05.18").setDepartureTime("17:10")
                .setArrivalDate("12.05.18").setArrivalTime("23:45").setCarrier(TK).setStops(1).setPrice(13600));

        expectedTickets.add(new Ticket().setOrigin("VVO").setOriginName("Владивосток").setDestination("UFA")
                .setDestinationName("Уфа").setDepartureDate("12.05.18").setDepartureTime("15:15")
                .setArrivalDate("12.05.18").setArrivalTime("17:45").setCarrier(TK).setStops(1).setPrice(33400));

        expectedTickets.add(new Ticket().setOrigin("VVO").setOriginName("Владивосток").setDestination("TLV")
                .setDestinationName("Тель-Авив").setDepartureDate("12.05.18").setDepartureTime("6:10")
                .setArrivalDate("12.05.18").setArrivalTime("15:25").setCarrier(TK).setStops(0).setPrice(14250));

        expectedTickets.add(new Ticket().setOrigin("LRN").setOriginName("Ларнака").setDestination("TLV")
                .setDestinationName("Тель-Авив").setDepartureDate("12.05.18").setDepartureTime("12:50")
                .setArrivalDate("12.05.18").setArrivalTime("14:30").setCarrier(SU).setStops(1).setPrice(7000));

        expectedTickets.add(new Ticket().setOrigin("VVO").setOriginName("Владивосток").setDestination("TLV")
                .setDestinationName("Тель-Авив").setDepartureDate("12.05.18").setDepartureTime("16:50")
                .setArrivalDate("12.05.18").setArrivalTime("23:35").setCarrier(SU).setStops(1).setPrice(16700));

        expectedTickets.add(new Ticket().setOrigin("VVO").setOriginName("Владивосток").setDestination("TLV")
                .setDestinationName("Тель-Авив").setDepartureDate("12.05.18").setDepartureTime("6:10")
                .setArrivalDate("12.05.18").setArrivalTime("16:15").setCarrier(SU).setStops(1).setPrice(16700));
    }

    @Test
    void normalJsonParserTest() throws IOException {
        List<Ticket> actualTickets = Parser.getData(testFile);

        assertThat(actualTickets).hasSameSizeAs(expectedTickets);
    }

    @Test
    void emptyAndWrongFilesParserTest() {
        assertThrows(UnsupportedFileOrFormat.class, () -> Parser.getData(emptyFile));
        assertThrows(UnsupportedFileOrFormat.class, () -> Parser.getData(wrongFile));
    }
}
