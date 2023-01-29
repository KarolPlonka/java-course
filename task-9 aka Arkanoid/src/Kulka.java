import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.lang.Math;

class Kulka extends Ellipse2D.Float
{
   Plansza p;
   Belka b;
   Cegielka[] c;
   int c_amount;
   JTextField score_display;
   int score;
   boolean isGameWon = false;
    
   int dx, dy;
 
   Kulka(Plansza p,int x,int y,int dx,int dy, Belka b, Cegielka[] c, int c_amount, JTextField score) 
   {                                          
      this.x=x;                               
      this.y=y;                               
      this.width=10;                          
      this.height=10;                         
 
      this.p=p;
      this.b=b;
      this.c=c;
      this.c_amount=c_amount;
      
      this.dx=dx;                             
      this.dy=dy;

      this.score_display = score;
   }
   
   void checkCollisionBelka(){
      if(
         this.x + this.width > b.x &&
         this.x - this.width < b.x + b.width &&
         this.y + this.height > b.y &&
         this.y - this.height < b.y
      )
      {
         this.dy=-this.dy;
         if(this.x < b.x + (b.width/2)){
            this.dx = -Math.abs(this.dx);
            //System.out.println("Hit belka lewa");
         }
         else{
            this.dx = Math.abs(this.dx);
            //System.out.println("Hit belka prawa");
         }
      }
   }
   
   void checkCollisionCegielki(){
      for (int i = 0; i < this.c_amount; i++) {
         if(
            c[i].visible &&
            this.x + this.width > c[i].x &&
            this.x < c[i].x + c[i].width &&
            this.y + this.height > c[i].y  &&
            this.y - this.height < c[i].y
         ){
            if(this.y > c[i].y && this.y  < c[i].y + c[i].height) this.dy=-this.dy;
            else this.dx=-this.dx;
            
            c[i].setVisiblity(false);

            score+=1;

            //check if won
            if (score == c_amount){
               score_display.setText("You won. Score: " + Integer.toString(score)); 
               isGameWon = true;
               p.repaint();
               return;
            }

            score_display.setText("Score: " + Integer.toString(score));

            p.repaint();
            //System.out.println("Hit cegla");
         }
      }
   }
 
   boolean nextKrok()                                        
   {                                                     
      x+=this.dx;                                             
      y+=this.dy;
      
 
      if(getMinX()<0 || getMaxX()>p.getWidth())  this.dx=-this.dx; 
      if(getMinY()<30) this.dy=-this.dy;
      
      if(getMaxY()>361){
         score_display.setText("You lost. Score: " + Integer.toString(score)); 
         return false;
      }

      this.checkCollisionBelka();
      this.checkCollisionCegielki();

      if(this.isGameWon) return false;
 
      p.repaint(); 
      Toolkit.getDefaultToolkit().sync();
      
      return true;
   }
}