package json;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final  Monitor monitor = new Monitor(false,27, "VG279Q", new Producer("ASUS"),
                new String[]{"1920x1080","144Гц"});

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(monitor));

        /* Модифицируем json-строку */
        final String monitorJson =
                "{"
                        + "\"curved_screen\":false,"
                        + "\"diagonal\":35,"
                        +"\"name_model\":27GN600,"
                        + "\"producer\":"
                        + "{"
                        + "\"name\":\"LG\""
                        + "},"
                        + "\"characteristics\":"
                        + "[\"1920x1080\",\"60Гц\",\"HDMI\"]"
                        + "}";
        final Monitor mon = gson.fromJson(monitorJson,  Monitor.class);
        System.out.println(mon);
    }
}
