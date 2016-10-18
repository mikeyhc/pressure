package net.atmosia.pressure;

public class Simulation {
    public static final int DEFAULT_WIDTH  = 16;
    public static final int DEFAULT_HEIGHT = 16;

    private Cell[][] cells;

    public Simulation() {
        this(DEFAULT_HEIGHT, DEFAULT_WIDTH);
    }

    public Simulation(int height, int width) {
        this.cells = new Cell[height][width];
    }

    public int height() { return this.cells.length; }
    public int width() { return this.cells[0].length; }

    public Cell setCell(int x, int y, Cell c) {
        Cell old = this.cells[y][x];
        this.cells[y][x] = c;
        return old;
    }

    public Cell getCell(int x, int y) {
        return this.cells[y][x];
    }
}
