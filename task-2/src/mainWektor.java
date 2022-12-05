public class mainWektor {

    public static void main(String[] args) {
        Wektor obj, obj2;
        obj = new Wektor(6, 8, 2);
        obj2 = new Wektor(3, 7, 2);

        System.out.println("Wektor 1: " + obj);
        System.out.println("Wektor 2: " + obj2);

        Wektor obj3=obj.plus(obj2);
        System.out.println("\n" + obj + " + " + obj2 + " = " + obj3);

        System.out.println("\nIloczyn wektorowy: ");
        Wektor obj4=obj.iloczyn_wektorowy(obj2);
        System.out.println(obj + " x " + obj2 + " = " + obj4);

        System.out.println("\nIloczyn skalarny: ");
        double skalar=obj.iloczyn_skalarny(obj2);
        System.out.println(obj + " * " + obj2 + " = " + skalar);

        double dlugosc=obj.dlugosc();
        System.out.println("\nDługosc wektora " + obj + " = " + dlugosc);

    }
}
