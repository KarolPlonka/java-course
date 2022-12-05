import java.io.*;
public class A
{
   static double KURS=3.8;
 
   public static void main(String[] args)                                        
   {                                                                             
      try                                                                        
      {                                                                          
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
 
         System.out.print("$: ");                                                
         String str=br.readLine();                                               
 
         double x=Double.parseDouble(str);                                       
         System.out.println("PLN: "+x*KURS);                                     
      }                                                                          
 
      catch(IOException e1)                                                      
      {                                                                          
         System.out.println("wyjatek operacji wejscia/wyjscia");                 
      }                                                                          
 
      catch(NumberFormatException e2)                                            
      {                                                                          
         System.out.println("nieprawidlowy format liczby");                      
      }                                                                          
   }                                                                             
}