package laborator6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveButton=new JButton("Save");
    JButton loadButton=new JButton("Load");
    JButton resetButton=new JButton("Reset");
    JButton exitButton=new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init()
    {
        setLayout((new GridLayout(1,4)));
        add(saveButton);
        add(loadButton);
        add(resetButton);
        add(exitButton);
        saveButton.addActionListener(this::save);
        loadButton.addActionListener(this::save);
        resetButton.addActionListener(this::save);
        exitButton.addActionListener(this::save);
    }

    private void save(ActionEvent actionEvent) {
        try{
            ImageIO.write(frame.drawingPanel.image,"PNG",new File("d:/test.png"));
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
