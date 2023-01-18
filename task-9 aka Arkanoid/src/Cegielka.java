import java.awt.geom.*;

class Cegielka extends Rectangle2D.Float
{
    boolean visible = true;

    Cegielka(int x, int y, int width, int height)       
    {                  
        this.x=x;       
        this.y=y;     
        this.width=width;  
        this.height=height; 
    }
    
    void setVisiblity(boolean b){
        this.visible = b;
    }
}