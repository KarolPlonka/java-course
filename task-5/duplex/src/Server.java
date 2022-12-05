import java.io.*;
import java.net.*;

// Class representing the thread for receiving messages
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
        // Loop until the "over" or "END" message is received
        String message = "";
        while (!message.equalsIgnoreCase("over") && !message.equalsIgnoreCase("END"))
        {
            // Read the next message from the socket
            try
            {
                message = sockReader.readLine();
                System.out.println("<Received:> " + message);
            }
            catch (IOException e)
            {
                System.out.println("Error reading from socket: " + e);
            }
        }

        // Print the "End of connection" message and exit
        System.out.println("End of connection");
        System.exit(0);
    }
}

public class Server
{
    public static final int PORT = 50007;

    public static void main(String args[]) throws IOException
    {
        try (// Create a server socket
        ServerSocket serv = new ServerSocket(PORT)) {
            // Wait for connection and create network socket
            System.out.println("Listening: " + serv);
            Socket socket = serv.accept();
            System.out.println("There is a connection: " + socket);

            // Create a receiving thread
            new Receive(socket).start();

            // Create streams of data taken from the keyboard and delivered to the socket
            BufferedReader keys = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter outp = new PrintWriter(socket.getOutputStream());

            // Loop until the "over" or "END" message is sent
            String message = "";
            while (!message.equalsIgnoreCase("over") && !message.equalsIgnoreCase("END"))
            {
                // Read the next message from the keyboard
                message = keys.readLine();

                // Send the message to the socket
                outp.println(message);
                outp.flush();
            }
        }

        // Print the "End of connection" message and exit
        System.out.println("End of connection");
        System.exit(0);

    }
}