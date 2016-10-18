package net.atmosia.pressure;

public class SinkTool implements Tool {
    public String name() { return "Sink"; }
    public void apply(Simulation s, int x, int y) {
        System.out.println("cell{" + x + "," + y + "} to Sink");
        s.setCell(x, y, new Sink());
    }
}
