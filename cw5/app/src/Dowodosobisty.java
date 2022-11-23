import java.io.BufferedReader;
import java.io.IOException;

public class Dowodosobisty extends Dokument {

    int id;
    
    
    public Dowodosobisty (BufferedReader br)
    {            
      this.wlasciciel=new Osoba(br);

      try                                                   
      {
        System.out.print("ID: ");                 
        this.id = Integer.parseInt(br.readLine()); 
      }      
                                                     
      catch(IOException e){
        throw new RuntimeException("Nie udało się stworzyć nowego dowodu osobistego");
      } 
    }

    public boolean czyPasuje(String wzorzec){
        if (this.wlasciciel.nazwisko.equalsIgnoreCase(wzorzec) || this.wlasciciel.imie.equalsIgnoreCase(wzorzec) || Integer.toString(this.id).equalsIgnoreCase(wzorzec))
            return true;
        else
            return false;
    }

    public Dowodosobisty (String imie, String nazwisko, int rok_urodzenia, int id)
    {
        this.wlasciciel = new Osoba(imie, nazwisko, rok_urodzenia);
        this.id = id;
    }

    public String toString()
    {
        return "Numer id: " + this.id + " wlasciciel: " + this.wlasciciel.toString();
    }
}