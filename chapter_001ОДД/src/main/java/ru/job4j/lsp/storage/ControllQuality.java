package ru.job4j.lsp.storage;

import java.util.ArrayList;
import java.util.List;

/**
 *Class ControllQuality класс для распделения продуктов.
 *@author chupin
 *@since 10.08.2020
 */

public class ControllQuality {

  private List<Storage> storages = new ArrayList<>();

  public ControllQuality(List<Storage> storages) {
    this.storages = storages;
  }


public void inventory(Food food) {
 for (Storage stor : storages) {
   if (stor.accept(food)) {
     stor.add(food);
     break;
   }
 }
}
}
