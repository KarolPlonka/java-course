import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.MultipleGradientPaint.CycleMethod;
 
class Plansza extends JPanel 
{                             
   public void paintComponent(Graphics g) 
   {                                      
      super.paintComponent(g);
      Graphics2D g2d=(Graphics2D)g;    

      //green rectangle
      g2d.setColor(Color.GREEN);
      //let rectangle be under red eclipse
      g2d.fillRect(225, 350, 140, 100);

      //gradient eclipse
      GradientPaint blackToGray = new GradientPaint(200, 40, Color.GREEN, 350, 160, Color.BLACK);
      Ellipse2D.Double circle_grad = new Ellipse2D.Double(200, 40, 150, 120);
      g2d.setPaint(blackToGray);
      g2d.fill(circle_grad);

      //radius gradeint ecliple
      Point2D center = new Point2D.Float(275, 260);
      float radius = 90;
      float[] dist = {0.05f, .95f};
      Color[] colors = {Color.RED, Color.BLACK};
      RadialGradientPaint pinkToGray = new RadialGradientPaint(center, radius, dist, colors,CycleMethod.REFLECT);
      Ellipse2D.Double circle_rad_grad = new Ellipse2D.Double(200, 200, 150, 120);
      g2d.setPaint(pinkToGray);
      g2d.fill(circle_rad_grad);

      //two eclipses
      Color c1 = new Color(1f,0f,0f,.3f );
      Ellipse2D.Double eclipse1 = new Ellipse2D.Double(20, 350, 100, 80);
      g2d.setPaint(c1);
      g2d.fill(eclipse1);

      Color c2 = new Color(1f, 0f, 1f, .3f);
      Ellipse2D.Double eclipse2 = new Ellipse2D.Double(70, 350, 100, 80);
      g2d.setPaint(c2);
      g2d.fill(eclipse2);


      // ARC 
      g2d.setColor(Color.BLUE);
      g2d.drawArc(50, 450, 100, 100, 25, 225);

      // Different Lines
      g2d.drawLine(75, 25, 75, 150);

      // Second line
      g2d.setStroke(new BasicStroke(5));
      g2d.drawLine(95, 25, 95, 150);

      // Third line
      g2d.drawRoundRect(115, 25, 3, 125, 5, 5);

      // Fourth line
      g2d.drawRoundRect(135, 25, 3, 10, 5, 5);
      g2d.drawRoundRect(135, 45, 3, 25, 5, 5);
      g2d.drawRoundRect(135, 95, 3, 10, 5, 5);
      g2d.drawRoundRect(135, 115, 3, 25, 5, 5);
      g2d.drawRoundRect(135, 155, 3, 10, 5, 5);
      g2d.drawRoundRect(135, 175, 3, 25, 5, 5);

      // Overlapping triangles without fill
      g2d.setColor(Color.RED);
      g2d.setStroke(new BasicStroke(5));
      //g2d.setTransform(AffineTransform.getScaleInstance(1.75, 1.75));
      g2d.drawPolygon(new int[] { 250, 305, 250}, new int[] { 475, 475, 525 }, 3);
      g2d.drawPolygon(new int[] { 270, 370, 270 }, new int[] { 500, 500, 550 }, 3);
      

      //image eclipse
      String plik="plik.jpg";
      BufferedImage img;
      try
      {
        File f=new File(plik);
        img=ImageIO.read(f);
        g2d.setClip(new Ellipse2D.Float(20, 200, 150, 120));
        g2d.drawImage(img, 20, 200, 150, 120, null);
        g2d.dispose();
      } catch(IOException e){System.err.println("Problem z plikiem");}
      


      
   } 
}

public class App
{
   public static void main(String[] args)
   {

      Plansza p;
      p=new Plansza();

      JFrame jf=new JFrame();
      jf.add(p);
      jf.setTitle("Test grafiki");
      jf.setSize(400,600);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jf.setVisible(true);
   }                                                     
}