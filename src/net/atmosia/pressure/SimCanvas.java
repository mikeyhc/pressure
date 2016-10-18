package net.atmosia.pressure;

import java.awt.*;
import java.awt.event.*;

public class SimCanvas extends Canvas {
    private static final int WIDTH  = 640;
    private static final int HEIGHT = 640;
    public static final long serialVersionUID = 1L;

    private final Simulation sim;
    private int stepx, stepy;

    public SimCanvas(Simulation s, MouseListener listener) {
        super();
        // small hack to make sure there is always 1 pixel for last border
        this.setPreferredSize(new Dimension(WIDTH+1, HEIGHT+1));
        this.sim = s;
        this.stepx = WIDTH / this.sim.width();
        this.stepy = HEIGHT / this.sim.height();
        addMouseListener(listener);
    }

    @Override
    public void paint(Graphics g) {
        clear(g);
        drawTiles(g);
        drawBorders(g);
    }

    private void clear(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    private void drawTiles(Graphics g) {
        System.out.println("redrawing tiles");
        for(int y = 0; y < this.sim.height(); y++) {
            for(int x = 0; x < this.sim.width(); x++) {
                Cell c = this.sim.getCell(x, y);
                if(c != null) {
                    CellRenderer.render(c, g, x * stepx, y * stepy, stepx,
                                        stepy);
                }
            }
        }
    }

    private void drawBorders(Graphics g) {
        g.setColor(new Color(255, 0, 0));
        for(int x = 0; x <= this.getWidth(); x += this.stepx) {
            g.drawLine(x, 0, x, this.getHeight());
        }

        for(int y = 0; y <= this.getHeight(); y += this.stepy) {
            g.drawLine(0, y, this.getWidth(), y);
        }
    }
}
