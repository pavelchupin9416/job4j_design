package ru.job4j.isp.menu;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.function.Supplier;

public class ChapterExecutTest {

    @Test
    public void getCommand() {
        Supplier<Boolean> command = () -> true;
        ChapterExecut chapter = new ChapterExecut("1", "Задача 1", command);
        assertEquals(command, chapter.getCommand());
    }

    @Test
    public void addSubChapter() {
        ChapterExecut chapter = new ChapterExecut("1", "Задача 1", () -> true);
        ChapterExecut temp = new ChapterExecut("1.1", "Задача 1.1", () -> true);
        chapter.addSubChapter(temp);
        assertEquals(temp, chapter.getSubChapter().get(0));
    }
}
