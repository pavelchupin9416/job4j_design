package ru.job4j.isp.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {


    final private Menu menu;

    public Main() {
        this.menu = new MenuExecut(new ArrayList<>());
    }

    public Main fill() {
        menu.add(new ChapterExecut("1", "Задача 1", () -> {
            System.out.println("Вы выбрали пункт 1");
            return true;
        }));

        menu.add(new ChapterExecut("2", "Задача 2", () -> {
            System.out.println("Вы выбрали пункт 2");
            return true;
        }));
        menu.add(new ChapterExecut("2.1", "Задача 2.1", () -> {
            System.out.println("Вы выбрали пункт 2.1");
            return true;
        }), "2");
        menu.add(new ChapterExecut("3", "Задача 3", () -> {
            System.out.println("Вы выбрали пункт 3");
            return true;
        }));
        menu.add(new ChapterExecut("3.1", "Задача 3.1", () -> {
            System.out.println("Вы выбрали пункт 3.1");
            return true;
        }), "3");
        menu.add(new ChapterExecut("3.1.1", "Задача 3.1.1", () -> {
            System.out.println("Вы выбрали пункт 3.1.1");
            return true;
        }), "3.1");
        menu.add(new ChapterExecut("4", "Exit", () -> {
            System.out.println("Exit");
            return false;
        }));
        return this;
    }

    public void print() {
        boolean rsl = true;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (rsl) {
                List<Chapter> chapters = menu.chapters();
                for (Chapter chapter : chapters) {
                    System.out.println(chapter.getId() + " " +  chapter.getName());
                }
                System.out.print("Введите id: ");
                Chapter chapter = menu.choose(reader.readLine());
                if (chapter == null) {
                    rsl = true;
                    System.out.println("Введите существующий пункт меню");
                } else {
                    rsl = chapter.getCommand().get();
                    System.out.println("Нажмите enter для продолжения...");
                }
                reader.readLine();
            }
        }  catch (IOException e) {
                e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().fill().print();

    }


}
