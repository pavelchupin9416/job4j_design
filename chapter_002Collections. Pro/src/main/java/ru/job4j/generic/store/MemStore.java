package ru.job4j.generic.store;

import java.util.HashMap;
import java.util.Map;

/**
 *Class MemStore каркас хранилища.
 *@author Chupin Pavel
 *@since 30.06.2021
 */

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> mem = new HashMap<>();

    @Override
    public void add(T model) {
        mem.put(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result;
        if (mem.get(id) == null) {
            result = false;
        } else {
            result = mem.get(id).equals(mem.put(id, model));
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result;
        if (mem.get(id) == null) {
            result = false;
        } else {
            result = mem.get(id).equals(mem.remove(id));
        }
        return result;
    }

    @Override
    public T findById(String id) {
        return mem.get(id);
    }
}