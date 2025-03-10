package com.vikash.mongo.demo.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtil {

    private TestUtil() {
    }

    public static String readFile(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }
}
