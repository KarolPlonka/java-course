import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Plansza extends JPanel implements MouseMotionListener {
    Belka b;
    Kulka a;
    SilnikKulki s;
    Cegielka[] c;
    int c_amount;

    Plansza() {
        super();
        addMouseMotionListener(this);

        b = new Belka(100);
        
        c_amount = 36;
        int c_width = 80;
        int c_height = 10;
        int c_space_x = 10;
        int c_space_y = 10;
        
        c_width += c_space_x;
        c_height += c_space_y;
        
        c = new Cegielka[c_amount];
        for (int i = 0; i < c_amount; i++) {
            c[i] = new Cegielka(
                (i%4)*c_width + c_space_x,
                (i/4)*c_height + c_space_y,
                c_width - c_space_x,
                c_height - c_space_y
            );
        }
            
        a = new Kulka(this, 100, 200, 1, 1, b, c, c_amount);
        s = new SilnikKulki(a);
    }
        
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.fill(a);
        g2d.fill(b);
        
        g2d.setColor(Color.GRAY);
        for (int i = 0; i < c_amount; i++) {
            if(c[i].visible) g2d.fill(c[i]);
        }
    }
    
    public void mouseMoved(MouseEvent e) {
        b.setX(e.getX() - 50);
        repaint();
    }

    public void mouseDragged(MouseEvent e) {

    }
}