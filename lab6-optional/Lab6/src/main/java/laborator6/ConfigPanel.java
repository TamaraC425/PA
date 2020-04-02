package laborator6;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    int index;
    JLabel labelRegularPolygon;
    JSpinner sidesField;
    JComboBox colorCombo;
    JLabel labelCircle;
    JSpinner size1;
    JSpinner size2;
    JSpinner width;
    JSpinner height;
    JButton button=new JButton("Draw");
    public ConfigPanel(MainFrame frame,int index) {
        this.frame = frame;
        this.index=index;
        init();
    }
    private void init()
   {
       if(this.index==0){
       labelRegularPolygon=new JLabel("Number of sides:");
       sidesField=new JSpinner(new SpinnerNumberModel(0,0,100,1));
        sidesField.setValue(6);
        String s[]={"Random","Black"};
        colorCombo=new JComboBox(s);
        add(labelRegularPolygon);
        add(sidesField);
        add(colorCombo);
        add(button);
        button.addActionListener(this::draw);
    }
       else if(index==1)
       {
          labelCircle=new JLabel("Choose x");
          JLabel labelCircle2=new JLabel("Choose y");
          JLabel labelWidth=new JLabel("Choose width");
          JLabel labelHeight=new JLabel("Choose height");
          size1=new JSpinner(new SpinnerNumberModel(0,0,200,1));
           size1.setValue(100);
           size2=new JSpinner(new SpinnerNumberModel(0,0,200,1));
           size2.setValue(100);
           width=new JSpinner(new SpinnerNumberModel(0,0,200,1));
           width.setValue(100);
           height=new JSpinner(new SpinnerNumberModel(0,0,200,1));
           height.setValue(100);
           add(labelCircle);
           add(size1);
           add(labelCircle2);
           add(size2);
           add(labelWidth);
           add(width);
           add(labelHeight);
           add(height);
           add(button);
           button.addActionListener(this::draw);

       }
}
    private void draw(ActionEvent actionEvent) {
    }
    }
