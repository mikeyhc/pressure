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

    public int inc_cell(Cell[][] grid, int x, int y, int delta) {
        if(x < 0 || y < 0 || x >= grid[0].length || y >= grid.length)
            return delta;
        if(grid[y][x] != null && grid[y][x].canInc())
            return grid[y][x].inc(delta);
        return delta;
    }

    public void inc_near_cell(Cell[][] grid, int x, int y) {
        if(grid[y][x] == null) return;

        int delta = this.cells[y][x].delta();

        int inc_total = 0;
        if(this.cells[y][x - 1].canInc()) inc_total++;
        if(this.cells[y - 1][x].canInc()) inc_total++;
        if(this.cells[y][x + 1].canInc()) inc_total++;
        if(this.cells[y + 1][x].canInc()) inc_total++;

        int rem = inc_cell(grid, x - 1, y, delta / inc_total);
        rem += inc_cell(grid, x, y - 1, delta / inc_total);
        rem += inc_cell(grid, x + 1, y, delta / inc_total);
        rem += inc_cell(grid, x, y + 1, delta / inc_total);
        grid[y][x].addRemainder(rem);
    }

    public void tick() {
        Cell[][] grid  = new Cell[this.cells.length][this.cells[0].length];
        for(int y = 0; y < this.cells.length; y++) {
            for(int x =0; x < this.cells[0].length; x++) {
                if(grid[y][x] != null) {
                    grid[y][x] = this.cells[y][x].copy();
                    inc_near_cell(grid, x, y);
                }
            }
        }
        for(int y = 0; y < grid.length; y++) {
            for(int x =0; x < grid[0].length; x++) {
                if(grid[y][x] != null)
                    grid[y][x].tick();
            }
        }
    }
}
