package analiz;

import java.io.*;
import java.util.ArrayList;


public class Analizy {
    private final ArrayList <String> list = new ArrayList<>();
    private boolean statusServer = true;

    public void unavailable(String source, String target) {

       try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            in.lines().forEach(line -> {
               if ((line.startsWith("400") || line.startsWith("500")) && statusServer) {
                   int index = line.indexOf(" ");
                   list.add(line.substring(index + 1)+";");
                   statusServer = false;
               }
               if ((line.startsWith("200") || line.startsWith("300")) && !statusServer) {
                   int index = line.indexOf(" ");
                   list.add(line.substring(index + 1)+";"+System.lineSeparator());
                   statusServer = true;
               }
           });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            for(String element :list) {
                out.print(element);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String sourse = "server.log";
        String target = "unavailable.csv";
        new Analizy().unavailable(sourse, target);
    }
}