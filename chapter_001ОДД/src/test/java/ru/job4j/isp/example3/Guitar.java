package ru.job4j.isp.example3;

public class Guitar implements FingerStyle, Strumming, Tapping {
    @Override
    public void playFinger() {
        System.out.println("Играть пальцами!");
    }

    @Override
    public void playStrumming() {
        System.out.println("Играть чесом!");
    }

    @Override
    public void playTapping() {
        System.out.println("Играть ударами!");
    }
}
