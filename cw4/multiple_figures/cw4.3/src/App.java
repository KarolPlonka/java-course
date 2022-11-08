public class App
{
   public static void main(String[] args)                        
   {                                                             
        Figura z=new Okrag(2);                                     
        z.info();                                                  
 
        Figura[] a={new Okrag(8),new Okrag(3), new Trojkat(1, 3, 5, 2), new Rownoleglobok(10, 10, 30)}; 
        for(Figura f:a)                                            
        {                                                         
            f.info();                                             
        }
        Figura x;                                                  
        double suma=0;                                             

        for(int i=0;i<a.length;i++)                                
        {                                                          
            x = a[i];                                                 
            x.info();                                               
            suma = suma+x.pole();                                     
        }                                                          
 
      System.out.println("suma pol figur: "+suma);               
   }                                                             
}