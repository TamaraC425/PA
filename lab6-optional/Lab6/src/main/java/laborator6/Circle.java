package laborator6;

import java.awt.*;

public class Circle {
    int x, y, width, height;

    public Circle(int x, int y,int width,int height) {
        this.x = x;
        this.y = y;
        this.width=width;
        this.height=height;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(x,y,width,height);
    }
}
