class SilnikKulki extends Thread
{
   Kulka a;
 
   SilnikKulki(Kulka a) 
   {                    
      this.a=a;         
      start();          
   }                    
 
   public void run()                   
   {                                  
      try                             
      {                               
         while(true)                  
         {                            
            a.nextKrok();             
            sleep(15);                
         }                            
      }                               
      catch(InterruptedException e){} 
   }                                  
}