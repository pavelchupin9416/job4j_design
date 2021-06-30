package ru.job4j.generic.store;

/**
 *Class Store интерфейс контейнеров.
 *@author Chupin Pavel
 *@since 30.06.2021
 */

public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
