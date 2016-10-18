package net.atmosia.pressure;

public interface Tool {
    public String name();
    public void apply(Simulation s, int x, int y);
}
