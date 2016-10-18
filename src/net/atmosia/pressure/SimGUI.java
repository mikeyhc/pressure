package net.atmosia.pressure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimGUI extends JFrame implements MouseListener {
    private Simulation sim;
    private Canvas canvas;
    private Toolbox toolbox;
    private static final long serialVersionUID = 1L;

    public SimGUI(Simulation s) {
        super("Pressure");
        this.sim = s;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.canvas = new SimCanvas(this.sim, this);
        this.add(this.canvas, BorderLayout.WEST);
        this.toolbox = new Toolbox();
        this.add(toolbox, BorderLayout.EAST);
        this.pack();
    }

    public void run() {
        System.out.print("starting simulation");
        this.setVisible(true);
    }

    public void mouseExited(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }

    public void mousePressed(MouseEvent e) {
        int x = e.getX() / (this.canvas.getWidth() / this.sim.width());
        int y = e.getY() / (this.canvas.getHeight() / this.sim.height());
        System.out.println("working with cell{" + x + "," + y + "}");
        this.toolbox.applyTool(this.sim, x, y);
        this.canvas.repaint();
    }
}
