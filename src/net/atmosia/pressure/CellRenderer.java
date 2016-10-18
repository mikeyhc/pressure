package net.atmosia.pressure;

import java.awt.*;

public class CellRenderer {
    public static void render(Cell s, Graphics g, int x, int y, int w,
            int h) {
        Color c = null;
        if(s instanceof Source) {
            c = new Color(0, 0, 255);
        } else if(s instanceof Sink) {
            c = new Color(255, 0, 0);
        }
        g.setColor(c);
        g.fillRect(x, y, w, h);
    }
}
