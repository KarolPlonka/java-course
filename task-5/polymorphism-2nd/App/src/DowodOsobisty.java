import java.io.*;

class DowodOsobisty implements Serializable
{
   Osoba posiadacz;
   String numer;
 
   DowodOsobisty(BufferedReader br)      
   {                                     
      try                                
      {                                  
         this.posiadacz=new Osoba(br);   
 
         System.out.print("numer do: "); 
         this.numer=br.readLine();       
      }                                  
      catch(IOException e){}             
   }                                     
 
   public String toString()                                
   {                                                       
      return "<do:> "+posiadacz.toString()+" "+this.numer; 
   }                                                       
 
   void info()                  
   {                            
      System.out.println(this); 
   }                            
}