package ru.job4j.isp.menu;


import java.util.List;

public interface Menu {

    void add(Chapter chapter);

    void add(Chapter chapter, String chapterId);

    List<Chapter> chapters();

    Chapter choose(String id);
}
