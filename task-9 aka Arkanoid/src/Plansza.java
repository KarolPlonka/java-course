import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.MultipleGradientPaint.CycleMethod;

class Plansza extends JPanel implements MouseMotionListener {
    Belka b;
    Kulka a;
    SilnikKulki s;
    int top_margin;
    Cegielka[] c;
    int c_amount;
    JTextField score;

    Plansza() {
        super();
        addMouseMotionListener(this);

        b = new Belka(120);
        
        c_amount = 32;
        int c_width = 82;
        int c_height = 10;
        int c_space_x = 10;
        int c_space_y = 10;
        
        c_width += c_space_x;
        c_height += c_space_y;
        
        top_margin = 30;
        c = new Cegielka[c_amount];
        for (int i = 0; i < c_amount; i++) {
            c[i] = new Cegielka(
                (i%4)*c_width + c_space_x,
                (i/4)*c_height + c_space_y + top_margin,
                c_width - c_space_x,
                c_height - c_space_y
            );
        }

        score=new JTextField("Score: 0", 20);  
        score.setFont(new Font("Consolas", Font.BOLD, 19));
        score.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        score.setBounds(100,100,200,40);                     
        score.setEditable(false);
        score.setHorizontalAlignment(JTextField.CENTER);
        add(score);      
            
        a = new Kulka(this, 100, 200, 1, 1, b, c, c_amount, score);
        s = new SilnikKulki(a);

           
    }
        
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        Point2D center = new Point2D.Float(250, 150);
        float radius = 50;
        float[] dist = {0.05f, .95f};
        Color[] colors = {Color.CYAN, Color.MAGENTA};
        RadialGradientPaint pinkToGray = new RadialGradientPaint(center, radius, dist, colors,CycleMethod.REFLECT);
        g2d.setPaint(pinkToGray);
        g2d.fill(a);

        
        g2d.setPaint(Color.DARK_GRAY);
        g2d.fill(b);
        
        //cegiełki
        for (int i = 0; i < c_amount; i++) {
            int color = (int)(((double) i)/c_amount * 170) + 70;
            g2d.setColor(new Color(color, 140, 150));
            if(c[i].visible) g2d.fill(c[i]);
        }
        
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(0, 30, 400, 30);
    }
    
    public void mouseMoved(MouseEvent e) {
        b.setX(e.getX() - 50);
        repaint();
    }

    public void mouseDragged(MouseEvent e) {

    }
}