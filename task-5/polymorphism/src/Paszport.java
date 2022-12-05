import java.io.BufferedReader;
import java.io.IOException;

public class Paszport extends Dokument{
    
    int id;

    public Paszport (BufferedReader br)
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

    public Paszport(String imie, String nazwisko, int rok_urodzenia, int id)
    {
        this.wlasciciel = new Osoba(imie, nazwisko, rok_urodzenia);
    }

    public boolean czyPasuje(String wzorzec){
        if (this.wlasciciel.nazwisko.equalsIgnoreCase(wzorzec) || this.wlasciciel.imie.equalsIgnoreCase(wzorzec) || Integer.toString(this.id).equalsIgnoreCase(wzorzec))
            return true;
        else
            return false;
    }

    public String toString(){
        return "Numer id: " + this.id + " wlasciciel: " + this.wlasciciel.toString();
    }

}
