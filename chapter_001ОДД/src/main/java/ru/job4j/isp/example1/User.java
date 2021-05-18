package ru.job4j.isp.example1;

public class User {
    private final RF rf;
    private final Hdmi hdmi;


    public User(RF rf, Hdmi hdmi) {
        this.rf = rf;
        this.hdmi = hdmi;
    }

    public void connectHdmi() {
        hdmi.connectHdmi();
    }

    public void connectRF() {
        rf.connectRF();
    }
}
