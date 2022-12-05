import java.io.*;
import java.net.*;

public class Client
{
    public static final int PORT = 50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException
    {
        // Establishing a connection with the server
        Socket sock = new Socket(HOST, PORT);
        System.out.println("Connection established: " + sock);

        // Create a receiving thread
        new Receive(sock).start();

        // Create a sending thread
        new Send(sock).start();

        // Closing the connection
        sock.close();
    }
}