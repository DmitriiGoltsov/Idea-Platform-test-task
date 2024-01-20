package com.goltsov.idea.platform.test.unit;

import com.goltsov.idea.platform.exception.UnsupportedFileOrFormat;
import com.goltsov.idea.platform.mapping.Parser;
import com.goltsov.idea.platform.model.Carrier;
import com.goltsov.idea.platform.model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        expectedTickets.add(new Ticket("VVO", "Владивосток", "TLV", "Тель-Авив",
                "12.05.18", "16:20", "12.05.18", "22:10",
                Carrier.TK, 3,12400));
        expectedTickets.add(new Ticket("VVO","Владивосток","TLV","Тель-Авив",
                "12.05.18","17:20","12.05.18","23:50",
                Carrier.S7,1,13100));
        expectedTickets.add(new Ticket("VVO", "Владивосток","TLV","Тель-Авив",
                "12.05.18","12:10","12.05.18","18:10",
                Carrier.SU, 0,15300));
        expectedTickets.add(new Ticket("VVO","Владивосток","TLV","Тель-Авив",
                "12.05.18","17:00", "12.05.18", "23:30",
                Carrier.TK, 2, 11000));
        expectedTickets.add(new Ticket("VVO", "Владивосток", "TLV", "Тель-Авив",
                "12.05.18", "12:10", "12.05.18", "20:15",
                Carrier.BA, 3, 13400));

        expectedTickets.add(new Ticket("VVO", "Владивосток", "TLV", "Тель-Авив",
                "12.05.18", "9:40", "12.05.18", "19:25",
                Carrier.SU, 3, 12450));

        expectedTickets.add(new Ticket("VVO", "Владивосток", "TLV", "Тель-Авив",
                "12.05.18", "17:10", "12.05.18", "23:45",
                Carrier.TK, 1, 13600));

        expectedTickets.add(new Ticket("VVO", "Владивосток", "UFA", "Уфа",
                "12.05.18", "15:15", "12.05.18", "17:45",
                Carrier.TK, 1, 33400));

        expectedTickets.add(new Ticket("VVO", "Владивосток", "TLV", "Тель-Авив",
                "12.05.18", "6:10", "12.05.18", "15:25",
                Carrier.TK, 0, 14250));

        expectedTickets.add(new Ticket("LRN", "Ларнака", "TLV", "Тель-Авив",
                "12.05.18", "12:50", "12.05.18", "14:30",
                Carrier.SU, 1, 7000));

        expectedTickets.add(new Ticket("VVO", "Владивосток", "TLV", "Тель-Авив",
                "12.05.18", "16:50", "12.05.18", "23:35",
                Carrier.SU, 1, 16700));

        expectedTickets.add(new Ticket("VVO", "Владивосток", "TLV", "Тель-Авив",
                "12.05.18", "6:10", "12.05.18", "16:15",
                Carrier.S7, 0, 17400));
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
