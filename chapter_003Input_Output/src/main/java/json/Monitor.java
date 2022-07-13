package json;

import java.util.Arrays;

public class Monitor
{
    private final boolean curved_screen;
    private final int diagonal;
    private final String name_model;
    private final Producer producer;
    private final String[] characteristics;


    public Monitor(boolean curved_screen, int diagonal, String name_model,Producer producer, String[] characteristics) {
        this.curved_screen = curved_screen;
        this.diagonal = diagonal;
        this.name_model = name_model;
        this.producer = producer;
        this.characteristics = characteristics;
    }


    @Override
    public String toString() {
        return "Monitor{"
                + "name_model=" + name_model
                + ", curved_screen=" + curved_screen
                + ", diagonal=" + diagonal
                + ", producer=" + producer
                + ", characteristics=" + Arrays.toString(characteristics)
                + '}';
    }
}
