package search;


import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Not enough input parameters");
        }
        if (filePath(args[0])) {
            throw new IllegalArgumentException("Path incorrect. Usage java -jar search-1.jar ROOT_FOLDER File_Type.");
        }
        if(typeFile(args[1])) {
            throw new IllegalArgumentException("File type incorrect. Usage java -jar search-1.jar ROOT_FOLDER File_Type.");
        }
        String path = args[0];
        String fileTipe = args[1];

        Path start = Paths.get(path);
        search(start, p -> p.toFile().getName().endsWith(fileTipe)).forEach(System.out::println);
    }

    private static boolean filePath(String path) {
        boolean resualt = true;
        if (path.matches("^[A-Z]{1}:[\\a-zA-Za-яА-Я0-9]*$")) {
        Path file = Paths.get(path);
        resualt=!Files.exists(file);
        }
        return resualt;
    }

    private static boolean typeFile(String type) {
        return !(type.charAt(0) == '.' && type.substring(1).matches("^[a-z0-9]+$"));
    }


    public static List<Path> search(Path root, Predicate<Path> condition) {
        SearchFiles searcher = new SearchFiles(condition);
        try {
            Files.walkFileTree(root, searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searcher.getPaths();
    }
}