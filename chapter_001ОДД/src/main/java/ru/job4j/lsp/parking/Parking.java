package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

/**
 *Interface Parking интерфейс методов работы с парковкой.
 *@author chupin
 *@since 20.08.2020
 */
public class Parking {

  private List<Transport> transports = new ArrayList<>();
  private List<Transport> transportsTruck = new ArrayList<>();

    public List<Transport> getTransports() {
        return transports;
    }

    public List<Transport> getTransportsTruck() {
        return transportsTruck;
    }

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
   public boolean park(Transport transport)  {
      boolean result = true;
     if (transport.getSize() > 1) {
        if ((spotTruck - 1) >= 0) {
         transportsTruck.add(transport);
         spotTruck = spotTruck - 1;
        } else if ((spotCar - transport.getSize()) >= 0) {
          transports.add(transport);
          spotCar = spotCar - transport.getSize();
        } else {
           result = false;
        }
     } else if ((spotCar - 1) >= 0) {
        transports.add(transport);
        spotCar = spotCar - 1;
     } else {
        result = false;
     }
     return result;
   }

   /**
    * Отъезд транспорта
    * @param transport - уезжающий транспорт
    */
   public boolean leave(Transport transport) {
       boolean result = false;
      if (transport.getSize() > 1) {
          result = transportsTruck.remove(transport);
          if (!result) {
             result = transports.remove(transport);
          }
      } else {
         result = transports.remove(transport);
      }
      return  result;
   }
}
