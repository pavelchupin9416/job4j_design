package duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class DuplicatesFinder {

    private static void printDup(DuplicatesVisitor dupVisitor) {
        Map<FileProperty, List<Path>> map = dupVisitor.getMap();
        if (!map.isEmpty()) {
            map.entrySet().stream().filter(m -> m.getValue().size() > 1)
                    .forEach(listFileProperty -> {
                        System.out.println(listFileProperty.getKey().getName() +" Size:"+ listFileProperty.getKey().getSize());
                        listFileProperty.getValue().forEach(System.out::println);
                    });
        }
    }
    public static void main(String[] args)  {
        DuplicatesVisitor dupVisitor = new DuplicatesVisitor();
        try {
            Files.walkFileTree(Paths.get("G:\\Chupin\\Java\\data"),
                    dupVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printDup(dupVisitor);
    }
}