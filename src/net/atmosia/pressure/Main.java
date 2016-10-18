package net.atmosia.pressure;

public class Main {
    public static void main(String[] args) {
        System.out.println("starting pressure v0.1.0");
        Simulation sim = new Simulation();
        SimGUI gui = new SimGUI(sim);
        gui.run();
    }
}
