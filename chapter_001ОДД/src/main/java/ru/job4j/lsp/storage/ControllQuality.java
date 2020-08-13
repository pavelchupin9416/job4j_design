package ru.job4j.lsp.storage;

/**
 *Class ControllQuality класс для распделения продуктов.
 *@author chupin
 *@since 10.08.2020
 */

public class ControllQuality {

  private Storage warhouse;
  private Storage shop;
  private Storage trash;

  public ControllQuality(Storage warhouse, Storage shop, Storage trash) {
    this.warhouse = warhouse;
    this.shop = shop;
    this.trash = trash;
  }

public void inventory(Food food) {
  double shelLife = food.shellLife();
  if (shelLife < 0.25) {
   warhouse.add(food);
  } else if (0.25 <= shelLife & shelLife <= 0.75) {
    shop.add(food);
  } else if (shelLife > 0.75 & shelLife < 1) {
    food.setDiscount(20);
    shop.add(food);
  } else if (shelLife >= 1) {
    trash.add(food);
  }
}
}
