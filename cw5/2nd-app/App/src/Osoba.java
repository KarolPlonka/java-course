import java.io.*;

class Osoba implements Serializable
{
   String imie;
   String nazwisko;
   int rokUrodzenia;
 
   Osoba(String imie,String nazwisko,int rokUrodzenia) 
   {                                                   
      this.imie=imie;                                  
      this.nazwisko=nazwisko;                          
      this.rokUrodzenia=rokUrodzenia;                  
   }                                                   
 
   Osoba(BufferedReader br)                                 
   {                                                        
      try                                                   
      {                                                     
         System.out.print("imie: ");                        
         this.imie = br.readLine();                           
 
         System.out.print("nazwisko: ");                    
         this.nazwisko = br.readLine();                       
 
         System.out.print("rok urodzenia: ");               
         this.rokUrodzenia = Integer.parseInt(br.readLine()); 
      }                                                     
      catch(IOException e){}                                
   }                                                        
 
   public String toString()                                     
   {                                                            
      return this.imie + " " + this.nazwisko + " " + this.rokUrodzenia; 
   }                                                            
}