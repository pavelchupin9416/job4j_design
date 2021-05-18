package ru.job4j.isp.example3;

public class Musician {
    private final FingerStyle fingerStyle;
    private final Strumming strumming;

    public Musician(FingerStyle fingerStyle, Strumming strumming) {
        this.fingerStyle = fingerStyle;
        this.strumming = strumming;
    }

    public void playFinger() {
        fingerStyle.playFinger();
    }

    public void playStrumming() {
        strumming.playStrumming();
    }
}
