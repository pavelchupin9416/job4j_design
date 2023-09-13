package json;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final  Monitor monitor = new Monitor(false, 27, "VG279Q", new Producer("ASUS"),
                new String[]{"1920x1080", "144Гц"});

        /* JSONObject из json-строки строки */
        JSONObject jsonProducer = new JSONObject("{\"name\":\"ASUS\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("1920x1080");
        list.add("144Гц");
        JSONArray jsonCharacteristics = new JSONArray(list);

        /* JSONObject напрямую методом put */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("curved_screen", monitor.isCurvedScreen());
        jsonObject.put("diagonal", monitor.getDiagonal());
        jsonObject.put("name_model", monitor.getNameModel());
        jsonObject.put("producer", jsonProducer);
        jsonObject.put("characteristics", jsonCharacteristics);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(monitor).toString());

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(monitor));

        /* Модифицируем json-строку */
        final String monitorJson =
                "{"
                        + "\"curved_screen\":false,"
                        + "\"diagonal\":35,"
                        + "\"name_model\":27GN600,"
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
