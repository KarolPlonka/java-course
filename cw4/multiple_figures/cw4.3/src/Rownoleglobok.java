class Rownoleglobok extends Figura
{
   double a;
   double b;
   double alfa; /* */
 
   Rownoleglobok(double a,double b, double alfa) 
   {                                          
      this.a = a;                   
      this.b = b;               
      this.alfa = alfa;
   }                                          
 
   double pole() {return a * b * Math.sin(alfa);}                            
 
   double obwod() { return 2*a+2*b;}                                
 
   public String toString()                                
   {                                                       
      return "rownoleglobok o bokach: " + a + ", " + b; 
   }                                                       
}