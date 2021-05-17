package ru.job4j.isp.menu;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MenuExecutTest {

    @Test
    public void addChapter() {
        ChapterExecut chapter = new ChapterExecut("1", "Задача 1", () -> true);
        ChapterExecut chapter1 = new ChapterExecut("1.1", "Задача 1.1", () -> true);
        MenuExecut menu = new MenuExecut(new ArrayList<>());
        menu.add(chapter);
        menu.add(chapter1, "1");
        assertEquals(chapter1, menu.choose("1.1"));
    }

}
