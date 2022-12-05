import java.io.*;
import java.net.*;

public class Server
{
    public static final int PORT=50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String args[]) throws IOException
    {
        // Create a server socket
        ServerSocket serv = new ServerSocket(PORT);

        // Wait for connection and create network socket
        System.out.println("Listening: " + serv);
        Socket socket = serv.accept();
        System.out.println("There is a connection: " + socket);

        // Create a receiving thread
        new Receive(socket).start();

        // Create a sending thread
        new Send(socket).start();

        // Closing the connection
        serv.close();
        socket.close();
    }
}