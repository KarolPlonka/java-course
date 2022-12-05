public class mainUlamek {

    public static void main(String[] args) {
        Ulamek obj, obj2;
        obj = new Ulamek(6, 8);
        obj2 = new Ulamek(3, 7);

        System.out.println("Ulamek 1: " + obj);
        System.out.println("Ulamek 2: " + obj2);

        double wynik = obj.rozwDziesietne();
        System.out.println("\n" + "Rozwinięcie dziesiętne: " + wynik);

        Ulamek obj3=obj.plus(obj2);
        System.out.println("\n" + obj + " + " + obj2 + " = " + obj3);

        Ulamek obj4=obj.minus(obj2);
        System.out.println("\n" + obj + " - " + obj2 + " = " + obj4);

        Ulamek obj5=obj.razy(obj2);
        System.out.println("\n" + obj + " * " + obj2 + " = " + obj5);


        System.out.println("\nOdwroc ulamek: " + obj);
        obj.odwroc();
        System.out.println(obj);

        System.out.println("\nSkróc ulamek: " + obj);
        obj.skroc();
        System.out.println(obj);
    }
}
