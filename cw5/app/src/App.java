import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class App
{
   public static void main(String[] args)                                        
   {
      Dokument[] bazaDanych = {
         new Dowodosobisty(new BufferedReader(new InputStreamReader(System.in))),
         new Paszport(new BufferedReader(new InputStreamReader(System.in))),
         new Paszport(new BufferedReader(new InputStreamReader(System.in)))
      }; 

      Dokument z;                      
      
      System.out.println("Wzorzec: ");
      Scanner scanner = new Scanner(System.in);
      String wzorzec = scanner.nextLine();
      scanner.close();

      for(int i=0; i < bazaDanych.length; i++)                                       
      {                                                                          
         z = bazaDanych[i];                                                        
         if(z.czyPasuje(wzorzec)) System.out.println("znaleziono: " + z);       
      }                                                                
   }                                                                             
}