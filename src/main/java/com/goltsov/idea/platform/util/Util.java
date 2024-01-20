package com.goltsov.idea.platform.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Util {

    public static String getDataFormat(String filePath) {
        int index = filePath.lastIndexOf('.');

        return index > 0
                ? filePath.substring(index)
                : "";
    }
}
