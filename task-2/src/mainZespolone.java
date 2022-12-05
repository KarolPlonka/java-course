public class mainZespolone {

    public static void main(String[] args) {
        LiczbaZespolona obj, obj2;
        obj = new LiczbaZespolona(6, 8);
        obj2 = new LiczbaZespolona(3, 7);

        System.out.println("Liczba Zespolona 1: " + obj);
        System.out.println("Liczba Zespolona 2: " + obj2);

        LiczbaZespolona obj3=obj.plus(obj2);
        System.out.println("\n" + obj + " + " + obj2 + " = " + obj3);

        LiczbaZespolona obj4=obj.razy(obj2);
        System.out.println("\n" + obj + " * " + obj2 + " = " + obj4);

    }
}
