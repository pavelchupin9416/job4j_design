package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2022,2,25);
        User user = new User("Pavel",2,calendar);
        User user2 = new User("Pavel",2,calendar);
        Map<User,Object> map= new HashMap<>();
        map.put(user, new Object());
        map.put(user2,new Object());
        System.out.println(map);
    }
}
