import java.awt.Rectangle;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class rectangle extends Rectangle {
    public static void main(String[] args) throws Exception {
        Rectangle obj1 = new Rectangle(0,0,4,3);    
        Rectangle obj2 = new Rectangle(1, 1, 4, 3);
        System.out.println("Prostokat 1: " + obj1);
        System.out.println("Prostokat 2: " + obj2);

        Rectangle obj3 = obj1.intersection(obj2);
        System.out.println("\nCzesc wspolna prostokata 1 i 2: " + obj3);
        
        // java.awt.Rectangle[x=1,y=-1,width=4,height=3]

        Rectangle obj4 = new Rectangle(1, 1, 4, 5);
        Rectangle obj5 = new Rectangle(2, 0, 2, 3);
        System.out.println("\nProstokat 4: " + obj4);
        System.out.println("Prostokat 5: " + obj5);

        // użyta została metoda contains z klasy Rectangle
        System.out.println("\nCzy prostokat 4 zawiera prostokat 5? " + obj4.contains(obj5));
        
        Rectangle obj6 = new Rectangle(-3, 0, 6, 3);
        System.out.println("\nProstokat 6: " + obj6);
        System.out.println("Czy punkt (2, -1) zawiera się w prostokącie 6? " + obj6.contains(-2, 1));
        
        Rectangle obj7 = new Rectangle(1, 1, 4, 5);
        Rectangle obj8 = new Rectangle(4, -3, 4, 3);
        System.out.println("\nProstokat 7: " + obj7);
        System.out.println("Prostokat 8: " + obj8);

        System.out.println("Czy prostokąt 7 przecina prostokąt 8? "+ obj7.intersects(obj8));

        File file = new File("rectangle.txt");
        FileWriter fileWrite = new FileWriter(file);
        fileWrite.write("Prostokat 1: " + obj1);
    }
}