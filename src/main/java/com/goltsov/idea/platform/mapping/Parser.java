package com.goltsov.idea.platform.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import com.goltsov.idea.platform.exception.UnsupportedFileOrFormat;
import com.goltsov.idea.platform.model.Ticket;
import com.goltsov.idea.platform.util.Util;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Parser {

    public static List<Ticket> getData(File file) throws IOException {
        ObjectMapper mapper = getMapper(Util.getDataFormat(file.getPath()));

        List<Ticket> tickets = mapper.readValue(file, TicketWrapper.class).getTickets();

        if (tickets != null) {
            return tickets;
        } else {
            throw new UnsupportedFileOrFormat("Could not map file content to List. File is either empty or broken");
        }
    }

    private static ObjectMapper getMapper(String fileFormat) {

        switch (fileFormat) {
            case ".json" -> {
                return new ObjectMapper();
            }
            case ".yml", ".yaml" -> {
                return new YAMLMapper();
            }
            default -> throw new UnsupportedFileOrFormat("The format: " + fileFormat + " is not supported yet");
        }
    }


}
