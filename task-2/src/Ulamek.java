public class Ulamek {
    /**
     * Klasa Ulamek
     * Klasa reprezentuje ulamek
     * Klasa składa się z dwóch pól: licznik i mianownik
     * Klasa posiada konstruktor, który przyjmuje dwa parametry: licznik i mianownik
     * Klasa posiada metody: plus, minus, razy, rozwiniecie dziesietne, odwroc, skroc
     * 
     */
    

    // add comment to every public method

    int licznik;
    int mianownik;

    Ulamek(int licznik,int mianownik)
    {
        this.licznik = licznik;
        this.mianownik = mianownik;
    }

    /**
     * Reprezentacja ulamka jako string
     * @return String
     */


    public String toString() {
        return this.licznik + "/"  + this.mianownik;
    }

    public int getLicznik() {
        return licznik;
    }
    public void setLicznik(int licznik) {
        this.licznik = licznik;
    }

    public int getMianownik() {
        return mianownik;
    }

    public void setMianownik(int mianownik) {
        this.mianownik = mianownik;
    }

    double rozwDziesietne()
    {
        return (double) this.licznik / this.mianownik;
    }
    //wynik działania może być liczba zmiennoprzecinkową dlatego należy dokonać rzutowania na typ

    void odwroc()
    {
        this.licznik = this.licznik ^ this.mianownik ^ (this.mianownik = this.licznik);
    }
    //zamiana wartości dwóch zmiennych

    /*
     * GCD - helps us in function that reduces fraction
     *
     */

    int nwd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return nwd(n2, n1 % n2);
    }

    void skroc()
    {
        //korzystamy z reurencyjnej funkcji nwd która zwróc największy wspólny dzielinik
        int dzielnik = nwd(this.licznik, this.mianownik);
        this.licznik /= dzielnik;
        this.mianownik /= dzielnik;
    }

    /*
     * Dodawanie ulamkow
     * @return the sum of two fractions
     */

    Ulamek plus(Ulamek ulamek2)
    {
        int nowy_mianownik = this.mianownik * ulamek2.mianownik;
        int nowy_licznik = (this.licznik * ulamek2.mianownik) + (ulamek2.licznik * this.mianownik);

        return new Ulamek(nowy_licznik, nowy_mianownik);
    }
    /*
     * Odejmowanie ulamkow
     * @return the difference of two fractions
     */

    Ulamek minus(Ulamek ulamek2)
    {
        int nowy_mianownik = this.mianownik * ulamek2.mianownik;
        int nowy_licznik = (this.licznik * ulamek2.mianownik) - (ulamek2.licznik * this.mianownik);

        return new Ulamek(nowy_licznik, nowy_mianownik);
    }

    /*
     * Mnozenie ulamkow
     * @return the product of two fractions
     */

    Ulamek razy(Ulamek ulamek2)
    {
        int nowy_mianownik = this.mianownik * ulamek2.mianownik;
        int nowy_licznik = this.licznik * ulamek2.licznik;

        return new Ulamek(nowy_licznik, nowy_mianownik);
    }
}
