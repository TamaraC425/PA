import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DesignPanel  extends JPanel  implements MouseListener {
    private final MainFrame frame;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(500,500));
        setLayout(null);
        addMouseListener(this);
    }
    public void addComponent(JComponent component)
    {
        int width=component.getPreferredSize().width;
        int height=component.getPreferredSize().height;
        int x=(int)(Math.random()*500);
        int y=(int)(Math.random()*500);
        component.setBounds(x,y,width,height);
        component.setToolTipText(component.getClass().getName());
        this.add(component);
        frame.repaint();

    }
    public void displayComponentProperties()
    {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        displayComponentProperties();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
