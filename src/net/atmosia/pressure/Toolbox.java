package net.atmosia.pressure;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Toolbox extends JPanel implements ActionListener {
    public static final long serialVersionUID = 1L;
    private Tool currentTool;
    private JLabel toolLabel;
    private Tool[] tools = {
        new SourceTool(),
        new SinkTool(),
    };

    public Toolbox() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.currentTool = tools[0];
        this.toolLabel = new JLabel();
        updateLabel();
        this.add(this.toolLabel);
        addToolButtons();
    }

    public void applyTool(Simulation s, int x, int y) {
        this.currentTool.apply(s, x, y);
    }

    private void updateLabel() {
        this.toolLabel.setText("Current tool: " + this.currentTool.name());
    }

    private void addToolButtons() {
        this.add(new JLabel("Tools"));
        for(Tool tool : tools)
            this.add(new ToolButton(tool));
    }

    public void updateCell(int x, int y) {

    }

    public void actionPerformed(ActionEvent e) {
        this.currentTool = ((ToolButton)e.getSource()).tool;
        updateLabel();
        this.revalidate();
    }

    class ToolButton extends JButton {
        private static final long serialVersionUID = 1L;
        protected Tool tool;

        ToolButton(Tool tool) {
            super(tool.name());
            this.tool = tool;
            this.addActionListener(Toolbox.this);
        }
    }
}
