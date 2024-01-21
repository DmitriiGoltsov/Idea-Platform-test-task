package com.goltsov.idea.platform.util;

public class Util {

    public static String getDataFormat(String filePath) {
        int index = filePath.lastIndexOf('.');

        return index > 0
                ? filePath.substring(index)
                : "";
    }
}
