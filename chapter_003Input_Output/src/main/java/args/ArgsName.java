package args;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (values.get(key) == null) {
            throw new IllegalArgumentException("Некорректный ключ");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Отсутствуют параметры");
        }
        for (String arg : args) {
            int index= arg.indexOf("=");
            if (index == -1) {
                throw new IllegalArgumentException("Отсутствует символ =");
            }
            String key = "";

            if (arg.startsWith("-")) {
                key = arg.substring(1,index);
            } else {
                throw new IllegalArgumentException("Ключ должен начинаться с символа -");
            }
            String value = arg.substring(index + 1);
            if (value.equals("") || key.equals("")) {
                throw new IllegalArgumentException("Ключ/значение не заполнены");
            }
            values.put(key,value);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
