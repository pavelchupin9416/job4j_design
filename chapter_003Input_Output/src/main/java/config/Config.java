package config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Config {


    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().filter(x -> !x.startsWith("#") && x.length()>0).forEach(line -> {
                        if (line.contains("=") && line.indexOf("=")!=0 && line.substring(line.indexOf("=")).length()>1) {
                            int index = line.indexOf("=");
                            values.put(line.substring(0, index), line.substring(index + 1));
                        } else {
                            throw new IllegalArgumentException("Нарушен шаблон ключ=значение");
                        }
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);

    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}
