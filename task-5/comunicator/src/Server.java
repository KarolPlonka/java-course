import java.io.*;
import java.net.*;

public class Server
{
    public static final int PORT=50007;

    public static void main(String args[]) throws IOException
    {
        // create a server socket
        ServerSocket server;
        server = new ServerSocket(PORT);

        //wait for connection and create network socket
        System.out.println("Listening: " + server);
        Socket socket;
        socket = server.accept();
        System.out.println("There is a connection: " + socket);

        // create a stream of data downloaded from the network socket
        BufferedReader input;
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //communication - reading data from the stream
        String str;
        while ((str = input.readLine()) != null) {
            System.out.println("<Received:> " + str);
        }

        //closing the connection
        input.close();
        socket.close();
        server.close();
    }
}