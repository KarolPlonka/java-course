import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.String;
import java.lang.Math;
 
public class Kalk implements ActionListener
{
   JTextField t1;
   JButton b1;
   JButton bplus;
   JButton brow;
   JButton bdiv;
   JButton bmul;
   JButton bpow;
   JButton bsqrt;
   JButton bproc;
   JButton bdot;
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

   public double calculate(double x, double y, String opp){
      if      (opp.equals("+"))     {return x + y;}
      else if (opp.equals("-"))     {return x - y;}
      else if (opp.equals("*"))     {return x * y;}
      else if (opp.equals("/"))     {return x / y;}
      else if (opp.equals("^"))     {return Math.pow(x, y);}
      else if (opp.equals("%"))     {return x * y / 100;}

      else {return 0.0;}
   }    
 
   public void actionPerformed(ActionEvent e)                  
   {                                                           
      Object target = e.getSource();
                      
      //handle digits buttons
      if (((JButton)target).getToolTipText().equals("digit"))
      {
         System.out.println(((JButton)target).getText());                                      
         t1.setText(t1.getText()+((JButton)target).getText()); 
         t1.requestFocus();  
      }                                                    
 
      else if(target==bdot)                      
      {    
         t1.setText(t1.getText() + "."); 
         t1.requestFocus();                                  
      }    
      
      //handle opperators +,-,*,^,... 
      else if(((JButton)target).getToolTipText().equals("opp"))                                   
      {                                                                 
         x=Double.parseDouble(t1.getText());                       
         opp = ((JButton)target).getText();
         System.out.println(((JButton)target).getText());    
         t1.setText("");                                       
         t1.requestFocus();                                    
      }
                                                          
      //sqrt
      else if(target==bsqrt)                      
      {    
         //System.out.println("SQRT");                                                
         outcome = Math.sqrt(Double.parseDouble(t1.getText()));                                                    
         t1.setText(Double.toString(outcome));                       
         t1.requestFocus();                                       
      }                                                   
 
      else if(((JButton)target).getToolTipText().equals("Memory"))                         
      {    
         if(((JButton)target).getText().equals("M+")){
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
 
      else if(target==brow||target==t1)                        
      {    
         //System.out.println("row");    
         y=Double.parseDouble(t1.getText());                                             
         outcome = calculate(x, y, opp);                                                    
         t1.setText(Double.toString(outcome));                       
         t1.requestFocus();                                    
      }                                                        
   }                                                           
 
   void init()                                                                   
   {                                                                            
      //try                                                                     
      //{                                                                       
      //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());    
      //}                                                                       
      //catch(Exception e){}                                                    
 
      JFrame f=new JFrame();                                                    
      Container c=f.getContentPane();                                           
 
      GridBagLayout gbl=new GridBagLayout();                                    
      GridBagConstraints gbc=new GridBagConstraints();                          
      gbc.fill=GridBagConstraints.HORIZONTAL;                                   
      c.setLayout(gbl);                                                         
 
 
 
      t1=new JTextField(15);                                                    
      t1.addActionListener(this);                                               
      t1.setHorizontalAlignment(JTextField.RIGHT);                              
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
         DigitsButtons[i].setToolTipText("digit");                                                  
         gbc.gridx = i%3;                                                              
         gbc.gridy = i/3 + 1;                                                              
         gbc.gridwidth=1;                                                          
         gbc.ipadx=0;                                                              
         gbc.ipady=0;                                                              
         gbc.insets=new Insets(5,5,0,0);                                           
         gbl.setConstraints(DigitsButtons[i],gbc);
         c.add(DigitsButtons[i]);
      }
 
      
                                                                  
 
      bplus=new JButton("+");                                                   
      bplus.addActionListener(this);                                            
      bplus.setFocusable(false);                                                
      bplus.setToolTipText("opp");                                        
      gbc.gridx=0;                                                              
      gbc.gridy=5;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(bplus,gbc);                                            
      c.add(bplus);                                                             
 
 
      brow=new JButton("=");                                                    
      brow.addActionListener(this);                                             
      brow.setFocusable(false);                                                 
      brow.setToolTipText("wykonaj działanie");                                 
      gbc.gridx=1;                                                              
      gbc.gridy=5;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(brow,gbc);                                             
      c.add(brow);                                                            
 
 
      bdiv=new JButton("/");                                                    
      bdiv.addActionListener(this);                                             
      bdiv.setFocusable(false);                                                 
      bdiv.setToolTipText("opp");                                 
      gbc.gridx=2;                                                              
      gbc.gridy=5;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(bdiv,gbc);                                             
      c.add(bdiv);
 
 
      bmul=new JButton("*");                                                    
      bmul.addActionListener(this);                                             
      bmul.setFocusable(false);                                                 
      bmul.setToolTipText("opp");                                 
      gbc.gridx=0;                                                              
      gbc.gridy=6;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(bmul,gbc);                                             
      c.add(bmul);
 
 
      bpow=new JButton("^");                                                    
      bpow.addActionListener(this);                                             
      bpow.setFocusable(false);                                                 
      bpow.setToolTipText("opp");                                 
      gbc.gridx=2;                                                              
      gbc.gridy=6;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(bpow,gbc);                                             
      c.add(bpow);
 
 
      bsqrt=new JButton("sqrt");                                                    
      bsqrt.addActionListener(this);                                             
      bsqrt.setFocusable(false);                                                 
      bsqrt.setToolTipText("sqrt");                                 
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
      bproc.setToolTipText("opp");                                 
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
      bdot.setToolTipText(".");                                 
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
      bMA.setToolTipText("Memory");                                 
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
      bMC.setToolTipText("Memory");                                 
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
      bMR.setToolTipText("Memory");                                 
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