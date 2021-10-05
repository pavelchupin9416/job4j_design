package ru.job4j.lsp.storage;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class StorageTest {

  @Test
    public void whenProductToWarehouse() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storage> storages = List.of(warehouse, shop, trash);
        ControllQuality controllQuality = new ControllQuality(storages);
        LocalDate now = LocalDate.now();
        Date created = java.sql.Date.valueOf(now.minusDays(2));
        Date expaired = java.sql.Date.valueOf(now.plusDays(8));
        Food food = new Food("Milk", expaired, created, 56, 0);
        controllQuality.inventory(food);
        assertThat(food, is(warehouse.get(0)));
    }

    @Test
    public void whenProductToShop() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storage> storages = List.of(warehouse, shop, trash);
        ControllQuality controllQuality = new ControllQuality(storages);
        LocalDate now = LocalDate.now();
        Date created = java.sql.Date.valueOf(now.minusDays(4));
        Date expaired = java.sql.Date.valueOf(now.plusDays(6));
        Food food = new Food("Milk", expaired, created, 56, 0);
        controllQuality.inventory(food);
        assertThat(food, is(shop.get(0)));
    }

    @Test
    public void whenProducttoShopDiscount() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storage> storages = List.of(warehouse, shop, trash);
        ControllQuality controllQuality = new ControllQuality(storages);
        LocalDate now = LocalDate.now();
        Date created = java.sql.Date.valueOf(now.minusDays(8));
        Date expaired = java.sql.Date.valueOf(now.plusDays(2));
        Food food = new Food("Milk", expaired, created, 56, 0);
        controllQuality.inventory(food);
        assertThat(food, is(shop.get(0)));
    }

    @Test
    public void whenProductToTrash() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storage> storages = List.of(warehouse, shop, trash);
        ControllQuality controllQuality = new ControllQuality(storages);
        LocalDate now = LocalDate.now();
        Date created = java.sql.Date.valueOf(now.minusDays(10));
        Date expaired = java.sql.Date.valueOf(now.minusDays(2));
        Food food = new Food("Milk", expaired, created, 56, 0);
        controllQuality.inventory(food);
        assertThat(food, is(trash.get(0)));
    }

    @Test
    public void whenResortProduct() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storage> storages = List.of(warehouse, shop, trash);
        ControllQuality controllQuality = new ControllQuality(storages);
        LocalDate now = LocalDate.now();
        Date created = java.sql.Date.valueOf(now.minusDays(10));
        Date expaired = java.sql.Date.valueOf(now.minusDays(2));
        Food food = new Food("Milk", expaired, created, 56, 0);
        warehouse.add(food);
        Date created1 = java.sql.Date.valueOf(now.minusDays(2));
        Date expaired1 = java.sql.Date.valueOf(now.plusDays(8));
        Food food1 = new Food("Kefir", expaired1, created1, 56, 0);
        trash.add(food1);
        controllQuality.resort();
        assertThat(food, is(trash.get(0)));
    }
}
