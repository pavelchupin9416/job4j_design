package ru.job4j.generic.store;

/**
 *Class Base хранимый объект.
 *@author Chupin Pavel
 *@since 30.06.2021
 */

public abstract class Base {
    private final String id;

    public Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
