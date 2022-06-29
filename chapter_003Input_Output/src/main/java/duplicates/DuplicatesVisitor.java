package duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, List<Path>> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path path = file.toAbsolutePath();
        FileProperty fileProperty = new FileProperty(attrs.size(), file.toFile().getName());
        map.putIfAbsent(fileProperty, new ArrayList<>());
        List<Path> value = map.get(fileProperty);
        value.add(path);
        return super.visitFile(file, attrs);
    }

    public Map<FileProperty, List<Path>> getMap() {
        return map;
    }
}