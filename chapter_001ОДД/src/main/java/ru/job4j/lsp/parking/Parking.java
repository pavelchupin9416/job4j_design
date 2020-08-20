package ru.job4j.lsp.parking;

/**
 *Interface Parking интерфейс методов работы с парковкой.
 *@author chupin
 *@since 20.08.2020
 */
public interface Parking {

   public void park(Transport transport);

   public void leave(Transport transport);
}
