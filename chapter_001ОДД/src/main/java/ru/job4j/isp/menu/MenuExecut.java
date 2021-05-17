package ru.job4j.isp.menu;

import java.util.LinkedList;
import java.util.List;


/**
 *Class MenuExecut класс предназначет для работы с функционалом меню.
 *@author chupin
 *@since 17.05.2021
 */

public class MenuExecut implements Menu {

   private List<Chapter> chapters;

   public MenuExecut(List<Chapter> chapters) {
       this.chapters = chapters;
   }

    @Override
    public void add(Chapter chapter) {
        chapters.add(chapter);
    }

    @Override
    public void add(Chapter chapter, String chapterId) {

       Chapter temp = receiveChapter(chapterId);
        if (chapter.getId().equals(temp.getId())) {
            chapters.add(chapter);
        } else {
            temp.addSubChapter(chapter);
        }
    }


    @Override
    public Chapter choose(String id) {
       Chapter result = receiveChapter(id);
       return result;
    }

    @Override
    public List<Chapter> chapters() {
        LinkedList<Chapter> chapte = new LinkedList<>();
        LinkedList<Chapter> stack = new LinkedList<>(chapters);

        while (!stack.isEmpty()) {
            final Chapter item = stack.poll();
            stack.addAll(0, item.getSubChapter());
            chapte.add(item);
        }
        return chapte;
    }

    private Chapter receiveChapter(String id) {
        Chapter result = null;
        if (id != null) {
        LinkedList<Chapter> temp = new LinkedList<>(chapters);
        while (!temp.isEmpty()) {
            final Chapter chapter1 = temp.poll();
            if (id.equals(chapter1.getId())) {
                result = chapter1;
                break;
            }
            temp.addAll(0, chapter1.getSubChapter());
        }
        }
        return result;
    }
}
