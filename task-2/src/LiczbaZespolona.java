public class LiczbaZespolona {
    double re;
    double im;

    LiczbaZespolona(double re, double im){
        this.re = re;
        this.im = im;
    }

    LiczbaZespolona plus(LiczbaZespolona l2){
        return new LiczbaZespolona(this.re + l2.re, this.im + l2.im);
    }

    LiczbaZespolona razy(LiczbaZespolona l2){
        return new LiczbaZespolona(
                (this.re * l2.re) - (this.im * l2.im),
                (this.re * l2.im) + (this.im * l2.re)
        );// argumenty funkcji (konstruktora) zapisane w osobnych linijach aby poprawić wyraźistość kodu
    }

    public String toString() {
        return this.re + " + " + this.im + "i";
    }

}
