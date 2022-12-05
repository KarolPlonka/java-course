public class App
{
   public static void main(String[] args)                                                        
   {
        RectangleFile obj1 = new RectangleFile(0,0,4,3);
        System.out.println(obj1);

        obj1.save("prostokat.txt");
   }                                                                                             
}