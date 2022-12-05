import java.io.*;
import java.net.*;

class Receive extends Thread
{
    Socket socket;
    BufferedReader sockReader;

    public Receive(Socket sock) throws IOException
    {
        this.socket = sock;
        this.sockReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }

    public void run()
    {
        try {
            String message;
            while ((message = sockReader.readLine()) != null) {
                // Print received message to the console
                System.out.println(message);

                // If the received message is "over" or "END", end the connection
                if (message.equals("over") || message.equals("END")) {
                    System.out.println("End of connection");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
