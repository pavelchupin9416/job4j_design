package ru.job4j.isp.menu;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Supplier;


/**
 *Class ChapterExecut класс предназначет для работы с главами меню.
 *@author chupin
 *@since 17.05.2021
 */
public class ChapterExecut implements Chapter {



    private String id;


    private String name;

    private  Supplier<Boolean> command;

    private final List<Chapter> subChapters;


    public ChapterExecut(String id, String name, Supplier<Boolean> command) {
        this.id = id;
        this.name = name;
        this.command = command;
        this.subChapters = new ArrayList<>();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public Supplier<Boolean> getCommand() {
        return command;
    }

    @Override
    public List<Chapter> getSubChapter() {
        return subChapters;
    }

    @Override
    public void addSubChapter(Chapter chapter) {
        subChapters.add(chapter);
    }
}
