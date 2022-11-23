import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class App
{
   public static void main(String[] args)                                        
   {
      /*
      Dokument[] bazaDanych = {
               new Dowodosobisty("Jan", "Kowalski", 1990, 1),
               new Paszport("Jan", "Cwiertnia", 1990, 2), 
               new Dowodosobisty("Paweł", "Nowak", 1990, 3),
               new Paszport("Paweł", "Kowalski", 1990, 4)
      }; */
      //p1 = ""

      BufferedReader person1;
      try{person1 = new BufferedReader(new FileReader("cw5/app/src/person1.txt"));}
      catch(IOException e){System.out.println("Kurwa Error: " + e); return;}
      try{person1.close();}
      catch(IOException e){throw new RuntimeException("Cannot close file");}
      
      BufferedReader person2;
      try{person2 = new BufferedReader(new FileReader("cw5/app/src/person2.txt")); }
      catch(IOException e){throw new RuntimeException("File not found");}
      try{person2.close();}
      catch(IOException e){throw new RuntimeException("Cannot close file");}

      BufferedReader person3;
      try{person3 = new BufferedReader(new FileReader("cw5/app/src/person3.txt")); }
      catch(IOException e){throw new RuntimeException("File not found");}
      try{person3.close();}
      catch(IOException e){throw new RuntimeException("Cannot close file");}

      BufferedReader person4;
      try{person4 = new BufferedReader(new FileReader("cw5/app/src/person4.txt")); }
      catch(IOException e){throw new RuntimeException("File not found");}
      try{person4.close();}
      catch(IOException e){throw new RuntimeException("Cannot close file");}
      

      Dokument[] bazaDanych = {
               new Dowodosobisty(person1),
               new Paszport(person2), 
               new Dowodosobisty(person3),
               new Paszport(person4)
      }; 


      Dokument z;                                                                
      String wzorzec = "Kowalski";

      for(int i=0; i < bazaDanych.length; i++)                                       
      {                                                                          
         z = bazaDanych[i];                                                        
         if(z.czyPasuje(wzorzec)) System.out.println("znaleziono: " + z);       
      }                                                                          
   }                                                                             
}