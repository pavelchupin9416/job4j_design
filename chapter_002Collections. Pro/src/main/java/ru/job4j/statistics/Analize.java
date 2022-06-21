package ru.job4j.statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *Class Analize статистика по коллекции.
 *@author Chupin Pavel
 *@since 21.06.2022
 */

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added;
        int changed = 0;
        int deleted = 0;
        Map <Integer,String> map = new HashMap<>();
        for (User cur : current) {
            map.put(cur.getId(), cur.getName());
        }
        Set<Integer> keys= map.keySet();
        for (User pre : previous) {
            if (keys.contains(pre.getId())) {
                if(!pre.getName().equals(map.get(pre.getId()))){
                    changed++;
                }
            } else {
             deleted++;
            }
        }
        added = current.size() - (previous.size()-deleted);
        return new Info(added,changed,deleted);
    }
}
