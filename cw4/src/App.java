import java.awt.Point;

public class App
{
    public static void main(String[] args)                   
    {                                      
        Prostokat prostokat1 = new Prostokat(new Point(1, 1), 3, 4);                       
        prostokat1.info();
                                                                           
        

        Prostokat prostokat2=new Prostokat(new Point(0, 0), 6, 4);                      
        prostokat2.info();                                                         
        

        Prostokat prostokat3=new Prostokat(new Point(6, 0), 3, 4);                      
        prostokat3.info();    
        
        if(prostokat1.przylega(prostokat2)) { System.out.println("-- PRZYLEGAJO --\n"); }                                                    
        else                                { System.out.println("-- NIE PRZYLEGAJO--\n"); }   
        
        if(prostokat2.przylega(prostokat3)) { System.out.println("-- PRZYLEGAJO --\n"); }                                                    
        else                                { System.out.println("-- NIE PRZYLEGAJO--\n"); }   
    }                                              
}