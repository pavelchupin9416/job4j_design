package csvreader;

import args.ArgsName;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    private static List<Integer> columns = new ArrayList<>();

    public static void handle(ArgsName argsName) throws Exception {
        validate(argsName);
        String[] filter = getFilters(argsName);
        String delimiter = argsName.get("delimiter");
        Scanner scanner = new Scanner((new File(argsName.get("path"))));
        String[] line = scanner.nextLine().split(delimiter);
        columns = columnsFinder(line, filter);
        if ("stdout".equals(argsName.get("out"))) {
            System.out.println(joiner(line));
            while (scanner.hasNext()) {
                String out = joiner(scanner.nextLine().split(delimiter)).toString();
                if (!out.isEmpty()) {
                    System.out.println(out);
                }
            }
        } else {
            try (PrintWriter pw = new PrintWriter(new FileWriter(argsName.get("out"), Charset.forName("UTF-8")))) {
                pw.write(joiner(line).toString());
                pw.write(System.lineSeparator());
                while (scanner.hasNext()) {
                    String out = joiner(scanner.nextLine().split(delimiter)).toString();
                    if (!out.isEmpty()) {
                        pw.write(out);
                        pw.write(System.lineSeparator());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Integer> columnsFinder(String[] line, String[] filter) {
        for (int index = 0; index < line.length; index++) {
            for (int i = 0; i < filter.length; i++) {
                if (filter[i].equals(line[index])) {
                    columns.add(index);
                }
            }
        }
        return columns;
    }
    public static String[] getFilters(ArgsName argsName) {
        return  argsName.get("filter").split(",");
    }
    public static StringJoiner joiner(String[] line) {
        StringJoiner joiner = new StringJoiner(";");
        if (line.length > 0) {

            columns.forEach(column -> joiner.add(line[column]));
        }
        return joiner;
    }
    public static void validate(ArgsName argsName) {
        if (!Files.exists(Paths.get(argsName.get("path")))) {
            throw new IllegalArgumentException("Файла не существует или указан не корректный путь");
        }
        if (!"stdout".equals(argsName.get("out"))) {
            if (!Files.exists(Paths.get(argsName.get("out"))) || !argsName.get("out").endsWith(".csv"))  {
            throw new IllegalArgumentException("Путь к файлу файлу вывода некорректен");
            }
        }
    }
    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("Аргументы не заполнены.Аргументы должны иметь вид : -path= -delimiter=  -out=stdout= -filter=");
        }
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);

    }
}