// polynomial class
public class WielomianKwadratowy {
    private double a;
    private double b;
    private double c;
    private double delta;
    private double x1;
    private double x2;
    private double x0;
    private double y;

    // constructor

    public WielomianKwadratowy(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // delta

    public double delta() {
        delta = b * b - 4 * a * c;
        return delta;
    }

    // root 1

    public double pierwiastek1() {
        x1 = (-b - Math.sqrt(delta)) / (2 * a);
        return x1;
    }

    // root 2

    public double pierwiastek2() {
        x2 = (-b + Math.sqrt(delta)) / (2 * a);
        return x2;
    }

    // x0 value

    public double wierzcholek() {
        x0 = -b / (2 * a);
        return x0;
    }

    // general formula

    public double wartosc(double x) {
        y = a * x * x + b * x + c;
        return y;
    }
    // string representation of the object
    public String toString() {
        return a + "x^2 + " + b + "x + " + c;
    }

    //dodawanie wielomianow
    public WielomianKwadratowy plus(WielomianKwadratowy obj) {
        WielomianKwadratowy obj3 = new WielomianKwadratowy(a + obj.a, b + obj.b, c + obj.c);
        return obj3;
    }

    //odejmowanie wielomianow
    public WielomianKwadratowy minus(WielomianKwadratowy obj) {
        WielomianKwadratowy obj4 = new WielomianKwadratowy(a - obj.a, b - obj.b, c - obj.c);
        return obj4;
    }


}