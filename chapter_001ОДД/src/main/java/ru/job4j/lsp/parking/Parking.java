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
   List<Transport> transportsTruck = new ArrayList<>();

   int spotCar;
   int spotTruck;

   public Parking(int spotCar, int spotTruck) {
      this.spotCar = spotCar;
      this.spotTruck = spotTruck;
   }


   /**
    * Парковка транспорта
    * @param transport - паркующийся транспорт
    */
   public void park(Transport transport) throws Exception  {
     if (transport.IsTruck()) {
        if ((spotTruck - 1) >= 0) {
         transportsTruck.add(transport);
         spotTruck = spotTruck - 1;
        } else if ((spotCar - transport.getSize()) >= 0) {
          transports.add(transport);
          spotCar = spotCar - transport.getSize();
        } else {
           throw new Exception("На парковке нет мест!");
        }
     } else if ((spotCar - 1) >= 0) {
        transports.add(transport);
        spotCar = spotCar - 1;
     } else {
        throw new Exception("На парковке нет мест!");
     }
   }

   /**
    * Отъезд транспорта
    * @param transport - уезжающий транспорт
    */
   public void leave(Transport transport) {
      if (transport.IsTruck()) {
          transportsTruck.remove(transport);
          transports.remove(transport);
      } else {
          transports.remove(transport);
      }
   }
}
