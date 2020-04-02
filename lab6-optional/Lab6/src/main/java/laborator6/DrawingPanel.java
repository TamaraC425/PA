package laborator6;

import javax.swing.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W=800,H=600;
     BufferedImage image;
     Graphics2D graphics;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public Graphics2D getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics2D graphics) {
        this.graphics = graphics;
    }

    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createScreenImage(); init();
    }
    private  void createScreenImage()
    {
        image=new BufferedImage(W,H,BufferedImage.TYPE_INT_ARGB);
        graphics=image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,W,H);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShapePolygon(e.getX(),e.getY());repaint();
            }
        });
    }
    private void drawShapePolygon(int x,int y)
    {
        int radius =(int)(Math.random()*100+100);
        int sides = (int) frame.configPanel.sidesField.getValue();
        Random rand = new Random();
        Color color = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),rand.nextInt(100));
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }
    private void drawCircle()
    {
        int x=(int)frame.configPanel.size1.getValue();
        int y=(int)frame.configPanel.size2.getValue();
        int width=(int)frame.configPanel.width.getValue();
        int height=(int)frame.configPanel.height.getValue();
        Random rand = new Random();
        Color color = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),rand.nextInt(100));
        graphics.setColor(color);
        Circle circle=new Circle(x, y,width,height);
        circle.draw(graphics);
    }
    @Override
    public void update(Graphics g) { }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }


}
