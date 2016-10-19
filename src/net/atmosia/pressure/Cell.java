package net.atmosia.pressure;

public abstract class Cell {
    public static final int MAX = 100;
    public static final int MIN = 0;
    public static final int HARM = 80;

    private int remainder = 0;

    public boolean canInc() { return false; }
    public int delta() { return 0; }
    public abstract Cell tick();
    public abstract int inc(int amount);
    public abstract Cell copy();

    public void addRemainder(int r) { remainder += r; }
}
