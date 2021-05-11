package ru.job4j.isp.example1;

public class Monitor  implements Hdmi {
    @Override
    public void connectHdmi() {
        System.out.println("Hdmi подключен!");
    }
}
