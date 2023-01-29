class SilnikKulki extends Thread
{
   Kulka a;
   boolean gameInProgress = true;
 
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
            gameInProgress = a.nextKrok();    
            if(gameInProgress == false) return;         
            sleep(15);                
         }                            
      }                               
      catch(InterruptedException e){} 
   }                                  
}