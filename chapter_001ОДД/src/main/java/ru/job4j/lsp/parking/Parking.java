package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

/**
 *Interface Parking интерфейс методов работы с парковкой.
 *@author chupin
 *@since 20.08.2020
 */
public class Parking {

   List<Transport> transports = new ArrayList<>();

   int spotCar;
   int spotTruck;

   public Parking(int spotCar, int spotTruck) {
      this.spotCar = spotCar;
      this.spotTruck = spotTruck;
   }

   /**
    * Проверка возможности паркоки транспорта
    * @param transport - паркующийся транспорт
    */
   private boolean controlPark(Transport transport) {
      boolean result = true;
      if (transport.IsTruck()) {
         if ((spotTruck - 1) < 0 & (spotCar - transport.getSize()) < 0) {
              result = false;
         }
      } else {
         if (spotCar - transport.getSize() < 0) {
            result = false;
         }
      }
      return result;
   }

   /**
    * Парковка транспорта
    * @param transport - паркующийся транспорт
    */
   public void park(Transport transport) throws Exception  {
      if (controlPark(transport)) {
         if (transport.IsTruck()) {
            transports.add(transport);
            spotTruck = spotTruck - transport.getSize();
         } else {
            transports.add(transport);
            spotCar = spotCar - transport.getSize();
         }
      } else {
         throw new Exception("На парковке нет мест!");
      }
   }

   /**
    * Отъезд транспорта
    * @param transport - уезжающий транспорт
    */
   public void leave(Transport transport) {
      transports.remove(transport);
   }
}
