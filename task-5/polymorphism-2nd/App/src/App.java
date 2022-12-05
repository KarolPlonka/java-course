import java.io.*;

public class App {
    public static void main(String[] args)                                                  
    {
        System.out.println("-- do zapisu --");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DowodOsobisty  z = new DowodOsobisty (br);
        System.out.println(z);

        try
        {
            ObjectOutputStream outp=new ObjectOutputStream(new FileOutputStream("plik.dat"));
            outp.writeObject(z);
            outp.close();
        }
        catch(Exception e){throw new RuntimeException("Couldn't save file");}

        System.out.println("\n-- z pliku --");
        ObjectInputStream inp;

        try
        {
            inp=new ObjectInputStream(new FileInputStream("plik.dat"));
            Object o=inp.readObject();
            DowodOsobisty x = (DowodOsobisty)o;
            inp.close();
            System.out.println(x);
        }
        catch(FileNotFoundException e){throw new RuntimeException("Nie mozna odnalezc pliku");}
        catch(Exception e){throw new RuntimeException("Nie mozna odczytac pliku");}
    }
}