import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;

    public MainFrame()  {
        this.setLayout(new BorderLayout());
       // rootPane.setPreferredSize(new Dimension(1000,1000));
        init();
        this.setVisible(true);
    }
    private void init()
    {   setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.controlPanel=new ControlPanel(this);
        this.designPanel=new DesignPanel(this);
        pack();
        this.add(controlPanel,BorderLayout.NORTH);
        this.add(designPanel,BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        MainFrame mainFrame=new MainFrame();
    }
}
