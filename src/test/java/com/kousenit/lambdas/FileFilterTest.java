package com.kousenit.lambdas;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("ConstantConditions")
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

    @SuppressWarnings({"Convert2Lambda", "Anonymous2MethodRef"})
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

    @SuppressWarnings("Convert2MethodRef")
    @Test
    void listDirectories_expressionLambda() {
        File[] directories = root.listFiles(pathname -> pathname.isDirectory());
        assertEquals(27, directories.length);
    }

    @Test
    void listDirectories_methodReference() {
        File[] directories = root.listFiles(File::isDirectory);
        assertEquals(27, directories.length);
    }

    @SuppressWarnings({"Convert2MethodRef", "CodeBlock2Expr"})
    @Test
    void listDirectories_blockLambda() {
        File[] directories = root.listFiles(pathname -> {
            return pathname.isDirectory();
        });
        assertEquals(27, directories.length);
    }

    @SuppressWarnings("Convert2MethodRef")
    @Test
    void listDirectories_assignLambdaToVariable() {
        FileFilter filter = pathname -> pathname.isDirectory();
        File[] directories = root.listFiles(filter);
        assertEquals(27, directories.length);
    }

    // list only the Java source files
    @Test
    void listJavaSourceFiles() {
        // FilenameFilter
        File[] javaSrc = root.listFiles(((dir, name) -> name.endsWith(".java")));
        assertEquals(8, javaSrc.length);

        // FileFilter
        javaSrc = root.listFiles(pathname -> pathname.getName().contains(".java"));
        assertEquals(8, javaSrc.length);
    }

    @Test
    void forEachOnIterable() {
        List<String> strings = List.of("this", "is", "a", "list");
        // List.of produces an unmodifiable list -- all modification methods
        //  throw UnsupportedOperationException
//        strings.add("and");
//        strings.remove(0);

        // for-each loop
        for (String s : strings) {
            System.out.println(s);
        }
        // forEach on Iterable
        strings.forEach(s -> System.out.println(" The value of s is " + s));

        Map<String,Integer> map = Map.ofEntries(
                Map.entry("a", 1),
                Map.entry("b", 2),
                Map.entry("c", 2)
        );
        map.forEach((key,value) -> System.out.println(key + " maps to " + value));
    }
}
