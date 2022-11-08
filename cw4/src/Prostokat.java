import java.awt.Rectangle;
import java.awt.Point;


class Prostokat extends Rectangle
{
   Point wierzcholek;
   int dlugosc;
   int szerokosc;

   Prostokat(Point wierzcholek, int dlugosc, int szerokosc) {
      this.wierzcholek = wierzcholek;
      this.dlugosc = dlugosc;
      this.szerokosc = szerokosc;
   }

   public int getDlugosc() {
      return dlugosc;
   }

   public int getSzerokosc() {
      return szerokosc;
   }

   public boolean przylega(Prostokat prostokat2) {
        if (
            (this.wierzcholek.equals(prostokat2.wierzcholek) && this.szerokosc == prostokat2.szerokosc) ||
            ((this.wierzcholek.x + this.dlugosc) == prostokat2.wierzcholek.x && this.szerokosc == prostokat2.szerokosc) ||
            (this.wierzcholek.equals(prostokat2.wierzcholek) && this.dlugosc == prostokat2.dlugosc) ||
            ((this.wierzcholek.y + this.szerokosc) == prostokat2.wierzcholek.y && this.dlugosc == prostokat2.dlugosc)
        ){
            return true;
        }
        else{
            return false;
        }
   }

   

   Prostokat(int a,int b) 
   {                      
      super(a, b);         
   }                      

   void info()                  
   {                            
      System.out.println(this); 
   }                            
}