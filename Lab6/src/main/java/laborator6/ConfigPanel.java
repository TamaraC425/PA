package laborator6;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JComboBox colorCombo;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init()
   {
       label=new JLabel("Number of sides:");
       sidesField=new JSpinner(new SpinnerNumberModel(0,0,100,1));
        sidesField.setValue(6);
        String s[]={"Random","Black"};
        colorCombo=new JComboBox(s);
        add(label);
        add(sidesField);
        add(colorCombo);
    }
}