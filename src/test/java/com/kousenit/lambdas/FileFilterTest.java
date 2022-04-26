package com.kousenit.lambdas;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings({"Convert2MethodRef", "ConstantConditions", "Convert2Lambda", "Anonymous2MethodRef"})
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

    @Test
    void listDirectories_anonInnerClass() {
        File[] directories = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        assertEquals(27, directories.length);
    }

    @Test
    void listDirectories_expressionLambda() {
        File[] directories = root.listFiles(pathname -> pathname.isDirectory());
        assertEquals(27, directories.length);
    }

    @SuppressWarnings("CodeBlock2Expr")
    @Test
    void listDirectories_blockLambda() {
        File[] directories = root.listFiles(pathname -> {
            return pathname.isDirectory();
        });
        assertEquals(27, directories.length);
    }

    @Test
    void listDirectories_assignToVariable() {
        FileFilter filter = (File pathname) -> pathname.isDirectory();
        File[] directories = root.listFiles(filter);
        if (directories != null) {
            assertEquals(27, directories.length);
        }
    }

    // Test using FilenameFilter for Java source files (end with ".java")

    @Test
    void javaSrcFiles_filenamefilter() {
        FilenameFilter filter = (dir, name) -> name.endsWith(".java");
        File[] javaSrcFiles = root.listFiles(filter);
        assertEquals(8, javaSrcFiles.length);
        assertThat(javaSrcFiles).hasSize(8);  // AssertJ
        if (javaSrcFiles != null) {
            System.out.println(Arrays.toString(javaSrcFiles));
        }
    }

    @Test
    void iterateOverMap() {
        Map<String, Integer> map = Map.ofEntries(
                Map.entry("a", 1),
                Map.entry("b", 2),
                Map.entry("c", 2)
        );
        map.forEach((key,value) -> System.out.println(key + " maps to " + value));
    }
}
