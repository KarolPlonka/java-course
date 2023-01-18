import javax.swing.*;

public class Program
{
   public static void main(String[] args)                       
   {                                                           
      javax.swing.SwingUtilities.invokeLater(new Runnable()    
      {                                                        
         public void run()                                     
         {                                                     
            Plansza p;                                         
            p=new Plansza();                                   
 
            JFrame jf=new JFrame();                            
            jf.add(p);                                         
 
            jf.setTitle("Test grafiki");                       
            jf.setSize(400,370);                               
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            jf.setVisible(true);                               
         }                                                     
      });                                                      
   }                                                           
}