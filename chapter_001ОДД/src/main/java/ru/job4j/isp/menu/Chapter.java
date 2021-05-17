package ru.job4j.isp.menu;

import java.util.List;
import java.util.function.Supplier;

public interface Chapter {
    String getName();

    String getId();

    void addSubChapter(Chapter chapter);

    List<Chapter> getSubChapter();

    Supplier<Boolean> getCommand();
}
