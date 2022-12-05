public class Prostokat extends Figura{
    double bok1;
    double bok2;

    Prostokat(double bok1, double bok2) {
        this.bok1 = bok1;
        this.bok2 = bok2;
    }

    double pole() {
        return bok1 * bok2;
    }

    double obwod() {
        return 2 * bok1 + 2 * bok2;
    }

    public String toString() {
        return "prostokat o bokach " + bok1 + " i " + bok2;
    }
}
