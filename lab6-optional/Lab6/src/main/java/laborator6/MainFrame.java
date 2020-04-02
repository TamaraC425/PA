package laborator6;

import javax.swing.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel drawingPanel;
    ListOfShapesPanel shapesPanel;

    public MainFrame() {
        super("Drawing Application");
        init();
    }
    private void init()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
           drawingPanel=new DrawingPanel(this);
          add(drawingPanel,CENTER);
          controlPanel=new ControlPanel(this);
          add(controlPanel,SOUTH);
          shapesPanel=new ListOfShapesPanel(this);
          add(shapesPanel,WEST);

          pack();
    }
}
