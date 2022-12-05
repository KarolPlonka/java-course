import java.io.Serializable;

public abstract class Dokument implements Przeszukiwalne, Serializable
{
        Osoba wlasciciel;
        int id;
}