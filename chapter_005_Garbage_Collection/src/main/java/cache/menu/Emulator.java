package cache.menu;

import cache.DirFileCache;

import java.util.Scanner;

public class Emulator {
    private static Scanner scanner = new Scanner(System.in);
    private static DirFileCache dirFileCache;

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            showmenu();
            int select = scanner.nextInt();
            if (select == 1) {
                System.out.println("Введите директорию");
                dirFileCache = new DirFileCache(scanner.next());
                System.out.println("Директория установлена " + dirFileCache.getCachingDir());
            } else if (select == 2) {
                System.out.println("Введите имя файла для добавления в кэш");
                String key = scanner.next();
                dirFileCache.put(key, dirFileCache.get(key));
            } else if (select == 3) {
                System.out.println("Укажите файл");
                String key = scanner.next();
                System.out.println(dirFileCache.get(key));
            } else if (select == 4) {
                run = false;
            }
        }

    }

    public static void showmenu() {
        System.out.println("Menu:");
        System.out.println("1.Указать кэшируемую директорию" + System.lineSeparator()
                + "2.Загрузить содержимое файла в кэш" + System.lineSeparator()
                + "3.Получить содержимое файла из кэша" + System.lineSeparator()
                + "4.Выход");
        System.out.println("Выберете пункт меню:");
    }
}
