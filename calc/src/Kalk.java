import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Arrays;
 
public class Kalk implements ActionListener
{
   JTextField t1;
   JButton b1;
   JButton bplus,brow;
   
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
   
   double x,buf;
 
   public void actionPerformed(ActionEvent e)                  
   {                                                           
      Object target = e.getSource();
                      
      //handle digits buttons
      if (Arrays.stream(DigitsButtons).anyMatch(((JButton)target)::equals)){
         System.out.println(((JButton)target).getText());                                      
         t1.setText(t1.getText()+((JButton)target).getText()); 
         t1.requestFocus();  
      }                                             
 
      else if(target==bplus)                                   
      {                                                                 
         buf=Double.parseDouble(t1.getText());         
         t1.setText("");                                       
         t1.requestFocus();                                    
      }                                                        
 
      else if(target==brow||target==t1)                        
      {    
         System.out.println("bruh1");                                                           
         x=Double.parseDouble(t1.getText());                   
         x=buf+x;                                              
         t1.setText(Double.toString(x));                       
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
      bplus.setToolTipText("dodawanie");                                        
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
 
 
      brow=new JButton("/");                                                    
      brow.addActionListener(this);                                             
      brow.setFocusable(false);                                                 
      brow.setToolTipText("wykonaj działanie");                                 
      gbc.gridx=2;                                                              
      gbc.gridy=5;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(brow,gbc);                                             
      c.add(brow);                                                               
 
 
      brow=new JButton("*");                                                    
      brow.addActionListener(this);                                             
      brow.setFocusable(false);                                                 
      brow.setToolTipText("wykonaj działanie");                                 
      gbc.gridx=0;                                                              
      gbc.gridy=6;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(brow,gbc);                                             
      c.add(brow);                                                               
 
 
      brow=new JButton("+");                                                    
      brow.addActionListener(this);                                             
      brow.setFocusable(false);                                                 
      brow.setToolTipText("wykonaj działanie");                                 
      gbc.gridx=1;                                                              
      gbc.gridy=6;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(brow,gbc);                                             
      c.add(brow);                                                               
 
 
      brow=new JButton("^");                                                    
      brow.addActionListener(this);                                             
      brow.setFocusable(false);                                                 
      brow.setToolTipText("wykonaj działanie");                                 
      gbc.gridx=2;                                                              
      gbc.gridy=6;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(brow,gbc);                                             
      c.add(brow);                                                              
 
 
      brow=new JButton("sqrt");                                                    
      brow.addActionListener(this);                                             
      brow.setFocusable(false);                                                 
      brow.setToolTipText("wykonaj działanie");                                 
      gbc.gridx=0;                                                              
      gbc.gridy=7;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(brow,gbc);                                             
      c.add(brow);  
 
      brow=new JButton("%");                                                    
      brow.addActionListener(this);                                             
      brow.setFocusable(false);                                                 
      brow.setToolTipText("wykonaj działanie");                                 
      gbc.gridx=1;                                                              
      gbc.gridy=7;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(brow,gbc);                                             
      c.add(brow);      
 
      brow=new JButton(".");                                                    
      brow.addActionListener(this);                                             
      brow.setFocusable(false);                                                 
      brow.setToolTipText("wykonaj działanie");                                 
      gbc.gridx=2;                                                              
      gbc.gridy=7;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(brow,gbc);                                             
      c.add(brow);            
 
      brow=new JButton("M+");                                                    
      brow.addActionListener(this);                                             
      brow.setFocusable(false);                                                 
      brow.setToolTipText("wykonaj działanie");                                 
      gbc.gridx=0;                                                              
      gbc.gridy=8;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(brow,gbc);                                             
      c.add(brow);                
 
      brow=new JButton("MC");                                                    
      brow.addActionListener(this);                                             
      brow.setFocusable(false);                                                 
      brow.setToolTipText("wykonaj działanie");                                 
      gbc.gridx=1;                                                              
      gbc.gridy=8;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(brow,gbc);                                             
      c.add(brow);               
 
      brow=new JButton("MR");                                                    
      brow.addActionListener(this);                                             
      brow.setFocusable(false);                                                 
      brow.setToolTipText("wykonaj działanie");                                 
      gbc.gridx=2;                                                              
      gbc.gridy=8;                                                              
      gbc.gridwidth=1;                                                          
      gbc.ipadx=0;                                                             
      gbc.ipady=0;                                                              
      gbc.insets=new Insets(5,5,0,0);                                           
      gbl.setConstraints(brow,gbc);                                             
      c.add(brow);                                                 
                                                             
  
 
 
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