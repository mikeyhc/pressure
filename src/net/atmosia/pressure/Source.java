package net.atmosia.pressure;

public class Source extends Cell {
    public Cell tick() { return this; }

    public int inc(int amount) { return amount; }

    public Cell copy() {
        return new Source();
    }
}
