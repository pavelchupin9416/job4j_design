package zip;

import args.ArgsName;
import search.Search;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkup(ArgsName arguments) {
        if (Search.filePath(arguments.get("d"))) {
            throw new IllegalArgumentException("Path incorrect");
        }
        if ( Search.typeFile(arguments.get("e"))) {
            throw new IllegalArgumentException("File type incorrectly");
        }
        if (!arguments.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("The archive name is not specified correctly");
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Zip zip = new Zip();
        ArgsName arguments = ArgsName.of(args);
        checkup(arguments);
        File target = new File(arguments.get("o"));
        Path directory = Path.of(arguments.get("d"));
        String type = arguments.get("e");
        List<Path>  paths =  Search.search(directory, p -> !p.toFile().getName().endsWith(type));
        zip.packFiles(paths,target);
    }
}
