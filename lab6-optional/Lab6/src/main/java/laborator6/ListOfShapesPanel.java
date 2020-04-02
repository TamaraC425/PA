package laborator6;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import static java.awt.BorderLayout.NORTH;

public class ListOfShapesPanel extends JPanel {
    final MainFrame frame;
    JList list;
    JLabel label;
    ConfigPanel configPanel;

    public ListOfShapesPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        label = new JLabel("Select a shape");
        String string[] = {"Regular polygon", "Circle"};
        list = new JList(string);
        add(label);
        add(list);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (list.getSelectedIndex() == 0) {
                    if (configPanel != null) {
                        configPanel.removeAll();
                        configPanel.revalidate();
                    }
                    configPanel = new ConfigPanel(frame, 0);
                    configPanel.repaint();
                    add(configPanel, NORTH);
                }
                if (list.getSelectedIndex() == 1) {
                    if (configPanel != null) {
                        configPanel.removeAll();
                        configPanel.revalidate();
                    }
                    configPanel = new ConfigPanel(frame, 1);
                    configPanel.repaint();
                    add(configPanel, NORTH);
                }

            }
        });
    }

}
