import java.io.*;
public class App
{
    static double kurs_euro = 4.75;
    static double kurs_dolara = 4.74;
    static double kurs_zlotego = 1;
    static double kurs_rubla = 0.077;

 
   public static void main(String[] args)                                        
   {                                                                             
      try                                                                        
      {                       
            double wartosc_pln;

            System.out.println("Wybierz walute: euro / dolar / zloty / rubel");                    
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                            
            String waluta = br.readLine();       

            System.out.println("Wprowadz wartosc:");          
            br = new BufferedReader(new InputStreamReader(System.in));                                            
            String wartosc = br.readLine();   

            double parsed_value = Double.parseDouble(wartosc);
            
            if      (waluta.equals("euro"))  {wartosc_pln = parsed_value * kurs_euro; }
            else if (waluta.equals("dolar")) {wartosc_pln = parsed_value * kurs_dolara;} 
            else if (waluta.equals("zloty")) {wartosc_pln = parsed_value * kurs_zlotego;}
            else if (waluta.equals("rubel")) {wartosc_pln = parsed_value * kurs_rubla;}
            else    {
                System.out.println("Niepoprawna waluta");
                return;
            }
            
            System.out.println("Wartosc w euro: "       + Math.round(wartosc_pln / kurs_euro * 100.0) / 100.0);
            System.out.println("Wartosc w dolarach: "   + Math.round(wartosc_pln / kurs_dolara * 100.0) / 100.0);
            System.out.println("Wartosc w zlotowkach: " + Math.round(wartosc_pln / kurs_zlotego * 100.0) / 100.0);
            System.out.println("Wartosc w rublach: "    + Math.round(wartosc_pln / kurs_rubla * 100.0) / 100.0);

      }                                                                          
 
    catch(IOException e1)                                                      
    {                                                                          
        System.out.println("wyjatek operacji wejscia/wyjscia");                 
    }                                                                          
 
    catch(NumberFormatException e2)                                            
    {                                                                          
        System.out.println("nieprawidlowy format liczby");                      
    }                                                                          
   }                                                                             
}