import java.awt.Rectangle;
import java.io.*;

public class RectangleFile extends Rectangle{
    RectangleFile(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    public void save(String plik){

        try {
            FileWriter plik_do_zapisania = new FileWriter(plik);

            plik_do_zapisania.write(
                        "Wierzchołek: (" + this.x + "," + this.y + ")\n" +
                            "Długość:" + this.width + ", Szerokość: " + this.height
            );

            plik_do_zapisania.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
