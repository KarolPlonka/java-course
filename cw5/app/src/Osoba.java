import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;

public class Osoba implements Serializable{
    String imie;
    String nazwisko;
    int rokUrodzenia;

    Osoba (BufferedReader br){
        try{
            System.out.print("imie: ");
            this.imie = br.readLine();
            System.out.print("nazwisko: ");
            this.nazwisko = br.readLine();
            System.out.print("rok urodzenia: ");
            this.rokUrodzenia = Integer.parseInt(br.readLine());
        }
        catch(IOException e){throw new RuntimeException("Nie udało się stworzyć nowej osoby");}
    }

    Osoba (String imie, String nazwisko, int rokUrodzenia){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rokUrodzenia = rokUrodzenia;
    }

    public String toString(){
        return "imie: " + this.imie + " nazwisko: " + this.nazwisko + " rok urodzenia: " + this.rokUrodzenia;
    }
}
