package net.atmosia.pressure;

public class Sink extends Cell {
    private final static int GROWTH = 10;

    public Cell tick() { return this; }

    public int inc(int amount) { return amount; }

    @Override
    public int delta() {
        return GROWTH;
    }

    public Cell copy() {
        return new Sink();
    }
}
