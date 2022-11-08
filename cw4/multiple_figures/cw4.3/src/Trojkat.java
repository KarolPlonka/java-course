class Trojkat extends Figura {
    double a, b, c;
    double height;

    Trojkat(double a, double b, double c, double height) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.height = height;
    }
    double pole() {
        return a * height / 2;
    }

    double obwod() {
        return a + b + c;
    }

    public String toString() {
        return "Trojkat o bokach " + a + ", " + b + ", " + c + " i wysokosci " + height;
    }
}