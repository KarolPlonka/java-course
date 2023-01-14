import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.String;
import java.lang.Math;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Date;




public class Kalk implements ActionListener, KeyListener
{
   JTextField t1;
   
   JButton badd;
   JButton bsub;
   JButton brow;
   JButton bdiv;
   JButton bmul;
   JButton bpow;
   JButton bsqrt;
   JButton bproc;
   JButton bdot;
   
   JButton bclr;
   
   JButton bMA;
   JButton bMC;
   JButton bMR;
   
   JButton[] DigitsButtons = {
      new JButton("0"),
      new JButton("1"),
      new JButton("2"),
      new JButton("3"),
      new JButton("4"),
      new JButton("5"),
      new JButton("6"),
      new JButton("7"),
      new JButton("8"),
      new JButton("9")
   };
   
   double x,y,outcome,mem;
   boolean isMemStored;
   String opp;
   
   //file for logs
   FileWriter file;
   BufferedWriter  output;
   
   public static String sqrt_symbol = "\u221A";
   
   String log;
   Date date;

   public double calculate(double x, double y, String opp){
      if      (opp.equals("+"))     {return x + y;}
      else if (opp.equals("-"))     {return x - y;}
      else if (opp.equals("*"))     {return x * y;}
      else if (opp.equals("/"))     {return x / y;}
      else if (opp.equals("^"))     {return Math.pow(x, y);}
      else if (opp.equals("%"))     {return x * y / 100;}

      else {return 0.0;}
   }

   public void keyPressed(KeyEvent ke) {}
   public void keyReleased(KeyEvent ke){};
   
   @Override
   public void keyTyped(KeyEvent ke) {
      if (Character.isDigit(ke.getKeyChar())){
         t1.setText(t1.getText() + ke.getKeyChar());
      }
   }
 
   @Override
   public void actionPerformed(ActionEvent e)                  
   {                                                           
      Object target = e.getSource();
                      
      //handle digits buttons
      if(((JButton)target).getClientProperty("type").equals("digit"))   
      {                                  
         t1.setText(t1.getText()+((JButton)target).getText()); 
         t1.requestFocus();  
      }                                                     
 
      else if(target==bclr)                        
      {                                                   
         t1.setText("");                       
         t1.requestFocus();                                    
      }                                                   
 
      else if(target==bdot)                      
      {     
         t1.setText(t1.getText() + "."); 
         t1.requestFocus();                                  
      }    
      
      //handle opperators +,-,*,^,%
      else if(
         ((JButton)target).getClientProperty("type").equals("opp") &&
         t1.getText().equals("") == false
      )                                   
      {                                                                 
         x=Double.parseDouble(t1.getText());                       
         opp = ((JButton)target).getText();
         t1.setText("");                                       
         t1.requestFocus();                                    
      }
                                                          
      //sqrt
      else if(
         target==bsqrt &&
         t1.getText().equals("") == false
      )                      
      {                                                 
         outcome = Math.sqrt(Double.parseDouble(t1.getText())); 
         
         date = new Date();
         String log = date.toString() + "\t" + "square root of " + t1.getText() + " = " + Double.toString(outcome) + "\n";
         try {
            output.append(log);
            output.flush();
         } catch (Exception err) {err.printStackTrace();}     
                                                            
         t1.setText(Double.toString(outcome));                       
         t1.requestFocus();                                  
      }                                                   
 
      else if(((JButton)target).getClientProperty("type").equals("memory"))                        
      {    
         if(
            ((JButton)target).getText().equals("M+") &&
            t1.getText().equals("") == false
         )
         {
            mem = Double.parseDouble(t1.getText());
            isMemStored = true;
         }
         else if(((JButton)target).getText().equals("MR") && isMemStored){    
            t1.setText(Double.toString(mem));                                       
            t1.requestFocus();    
         }  
         else if(((JButton)target).getText().equals("MC")){    
            mem = 0; 
            isMemStored = false;
         }                       
      }                                                    
 
      else if(
         target==brow &&
         t1.getText().equals("") == false
      )                        
      {  
         y=Double.parseDouble(t1.getText());                                             
         outcome = calculate(x, y, opp);                                                    
         t1.setText(Double.toString(outcome));                       
         t1.requestFocus();   

         date = new Date();
         String log = date.toString() + "\t" + Double.toString(x) + " " + opp + " " + Double.toString(y) + " = " + Double.toString(outcome) + "\n";
         try {
            output.append(log);
            output.flush();
         } catch (Exception err) {err.printStackTrace();}
      }
      
      
   }                                                           
 
   void init()                                                                   
   {
      //file for logs   
      try {
         file = new FileWriter("log.txt");
         output = new BufferedWriter(file);
      } catch (Exception ex) {ex.printStackTrace();}                                                                 
                                                  
 
      JFrame f=new JFrame();                                                    
      Container c=f.getContentPane();                                           
 
      GridBagLayout gbl=new GridBagLayout();                                    
      GridBagConstraints gbc=new GridBagConstraints();                          
      gbc.fill=GridBagConstraints.HORIZONTAL;                                   
      c.setLayout(gbl);                                               
 
 
 
      t1=new JTextField(15);                                                    
      t1.addActionListener(this);                                               
      t1.setHorizontalAlignment(JTextField.RIGHT);                              
      t1.setEditable(false);
      t1.addKeyListener(this);   
      gbc.gridx=0;                                                              
      gbc.gridy=0;                                                              
      gbc.gridwidth=5;                                                          
      gbc.ipadx=0;                                                              
      gbc.ipady=5;                                                              
      gbc.insets=new Insets(5,5,0,5);                                           
      gbl.setConstraints(t1,gbc);                                               
      c.add(t1);
      
      //set up digits buttons
      for (int i = 0; i < 10; i++) {
         DigitsButtons[i].addActionListener(this);                                               
         DigitsButtons[i].setFocusable(false);  
         DigitsButtons[i].putClientProperty("type", "digit");                                                  
         gbc.gridx = i%3;                                                              
         gbc.gridy = i/3 + 1;                                                              
         gbc.gridwidth=1;                                                          
         gbc.ipadx=0;                                                              
         gbc.ipady=0;                                                              
         gbc.insets=new Insets(5,5,0,0);                                           
         gbl.setConstraints(DigitsButtons[i],gbc);
         c.add(DigitsButtons[i]);
      }                                                     
 
 
      bclr=new JButton("C");                                                    
      bclr.addActionListener(this);                                             
      bclr.setFocusable(false);                                                 
      bclr.setToolTipText("Clear");    
      bclr.putClientProperty("type", "clear");                               
      gbc.gridx=2;                                                              
      gbc.gridy=4;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(bclr,gbc);                                             
      c.add(bclr);                                                         
 
 
      brow=new JButton("=");                                                    
      brow.addActionListener(this);                                             
      brow.setFocusable(false);                                                 
      brow.setToolTipText("wykonaj działanie");   
      brow.putClientProperty("type", "row");                                
      gbc.gridx=1;                                                              
      gbc.gridy=5;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(brow,gbc);                                             
      c.add(brow);                                                          
                                                                  
 
      badd=new JButton("+");                                                   
      badd.addActionListener(this);                                            
      badd.setFocusable(false);
      badd.putClientProperty("type", "opp");                                     
      gbc.gridx=0;                                                              
      gbc.gridy=5;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(badd,gbc);                                            
      c.add(badd);                                                         
                                                                  
 
      bsub=new JButton("-");                                                   
      bsub.addActionListener(this);                                            
      bsub.setFocusable(false);
      bsub.putClientProperty("type", "opp");                                     
      gbc.gridx=1;                                                              
      gbc.gridy=6;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(bsub,gbc);                                            
      c.add(bsub);   
 
      bmul=new JButton("*");                                                    
      bmul.addActionListener(this);                                             
      bmul.setFocusable(false);                                                 
      bmul.putClientProperty("type", "opp");                                     
      gbc.gridx=0;                                                              
      gbc.gridy=6;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(bmul,gbc);                                             
      c.add(bmul);    
 
      bdiv=new JButton("/");                                                    
      bdiv.addActionListener(this);                                             
      bdiv.setFocusable(false);                                                 
      bdiv.putClientProperty("type", "opp");                                     
      gbc.gridx=2;                                                              
      gbc.gridy=5;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(bdiv,gbc);                                             
      c.add(bdiv);
 
 
      bpow=new JButton("^");                                                    
      bpow.addActionListener(this);                                             
      bpow.setFocusable(false);                                                 
      bpow.putClientProperty("type", "opp");                                     
      gbc.gridx=2;                                                              
      gbc.gridy=6;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(bpow,gbc);                                             
      c.add(bpow);
 
 
      bsqrt=new JButton(sqrt_symbol);                                                    
      bsqrt.addActionListener(this);                                             
      bsqrt.setFocusable(false);                              
      bsqrt.putClientProperty("type", "sqrt");                                                        
      gbc.gridx=0;                                                              
      gbc.gridy=7;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(bsqrt,gbc);                                             
      c.add(bsqrt);
 
      bproc=new JButton("%");                                                    
      bproc.addActionListener(this);                                             
      bproc.setFocusable(false);                                               
      bproc.putClientProperty("type", "opp");                                       
      gbc.gridx=1;                                                              
      gbc.gridy=7;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(bproc,gbc);                                             
      c.add(bproc);
 
      bdot=new JButton(".");                                                    
      bdot.addActionListener(this);                                             
      bdot.setFocusable(false);                                  
      bdot.putClientProperty("type", "dot");                               
      gbc.gridx=2;                                                              
      gbc.gridy=7;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(bdot,gbc);                                             
      c.add(bdot);
 
      bMA=new JButton("M+");                                                    
      bMA.addActionListener(this);                                             
      bMA.setFocusable(false);                                     
      bMA.putClientProperty("type", "memory");                               
      gbc.gridx=0;                                                              
      gbc.gridy=8;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(bMA,gbc);                                             
      c.add(bMA);                
 
      bMC=new JButton("MC");                                                    
      bMC.addActionListener(this);                                             
      bMC.setFocusable(false);                                    
      bMC.putClientProperty("type", "memory");                                 
      gbc.gridx=1;                                                              
      gbc.gridy=8;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(bMC,gbc);                                             
      c.add(bMC);               
 
      bMR=new JButton("MR");                                                    
      bMR.addActionListener(this);                                             
      bMR.setFocusable(false);                                   
      bMR.putClientProperty("type", "memory");                                 
      gbc.gridx=2;                                                              
      gbc.gridy=8;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(bMR,gbc);                                             
      c.add(bMR);                                                 
                                                             
  
 
 
      f.pack();                                                                 
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                         
      f.setTitle("Kalk");                                                       
      f.setVisible(true);                                                       
   }                                                                            
 
   public static void main(String[] args)          
   {                                               
      //do wersji 1.4                              
      //new Kalk().init();                         
 
      //od wersji 1.5                              
         SwingUtilities.invokeLater(new Runnable() 
      {                                            
         public void run()                         
         {                                         
            new Kalk().init();                     
         }                                         
      });                                          
   }                                               
}

