package ru.job4j.isp.example1;

public class Television implements Hdmi, RF {
    @Override
    public void connectHdmi() {
        System.out.println("Hdmi подключен!");
    }

    @Override
    public void connectRF() {
        System.out.println("Антена подключена!");
    }
}
