package laborator6;

import javax.swing.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel drawingPanel;

    public MainFrame() {
        super("Drawing Application");
        init();
    }
    private void init()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        configPanel=new ConfigPanel(this);
          add(configPanel,NORTH);
           drawingPanel=new DrawingPanel(this);
          add(drawingPanel,CENTER);
          controlPanel=new ControlPanel(this);
          add(controlPanel,SOUTH);
          pack();
    }
}
