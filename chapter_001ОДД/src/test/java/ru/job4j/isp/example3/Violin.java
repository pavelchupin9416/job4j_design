package ru.job4j.isp.example3;

public class Violin implements FingerStyle, Bow {
    @Override
    public void playBow() {
        System.out.println("Играть смычком!");
    }

    @Override
    public void playFinger() {
        System.out.println("Играть пальцами!");
    }
}
