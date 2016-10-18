package net.atmosia.pressure;

public class SourceTool implements Tool {
    public String name() { return "Source"; }
    public void apply(Simulation s, int x, int y) {
        System.out.println("cell{" + x + "," + y + "} to Source");
        s.setCell(x, y, new Source());
    }
}
