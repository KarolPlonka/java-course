public class mainWielomianKwadratowy {
    public static void main(String[] args) {
        WielomianKwadratowy obj, obj2;
        obj = new WielomianKwadratowy(1, 2, 3);
        obj2 = new WielomianKwadratowy(3, 2, 1);
        System.out.println(obj.delta);
        System.out.println("Wielomian 1: " + obj);
        System.out.println("Wielomian 2: " + obj2);
        System.out.println("Delta: " + obj.delta());
        System.out.println("Dodawanie: " + obj.plus(obj2));
        System.out.println("Odejmowanie: " + obj.minus(obj2));
    }
}