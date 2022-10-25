public class Wektor {
    double x;
    double y;
    double z;

    /*
     * Vector constructor
     * @param x
     * @param y
     * @param z
     */
    

    Wektor(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /*
     * Vector addition
     */

    Wektor plus(Wektor w2){
        return new Wektor(
            this.x + w2.x,
            this.y + w2.y,
            this.z + w2.z
        );
    }

    double rozwDziesietne()
    {
        return (double) this.x / this.y;
    }

    /*
     * product of two vectors
     */


    Wektor iloczyn_wektorowy(Wektor w2){
        return new Wektor(
                (this.y * w2.z) - (this.z * w2.y),
                (this.z * w2.x) - (this.x * w2.z),
                (this.x * w2.y) - (this.y * w2.x)
        );
    }

    /*
     * scalar product of two vectors
     */

    double iloczyn_skalarny(Wektor w2){
        return (this.x * w2.x) + (this.y * w2.y) + (this.z * w2.z);
    }

    double dlugosc(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    /*
     * string representation of vector
     */

    public String toString() {
        return "(" + this.x + "," + this.y + "," + this.z + ")";
    }


}
