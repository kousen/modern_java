package com.kousenit.lambdas;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileFilterTest {
    private final File root = new File("src/main/java/com/kousenit");

    @Test
    void listFiles() {
        File[] files = root.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
        assertEquals(35, files.length);
    }
}
