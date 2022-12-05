import java.io.*;
import java.net.*;

class ReceiverThread extends Thread
{
    Socket sock;
    BufferedReader sockReader;

    public ReceiverThread(Socket sock) throws IOException
    {
        this.sock = sock;
        this.sockReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }

    public void run()
    {
        try
        {
            // receiving messages loop
            String str;
            while (true)
            {
                str = sockReader.readLine();

                // check if the "over" or "END" message was received
                if (str.equalsIgnoreCase("over") || str.equalsIgnoreCase("end"))
                {
                    System.out.println("Received end message: " + str);
                    break;
                }

                System.out.println("Received: " + str);
            }

            // end of communication
            System.out.println("End of connection");
        }
        catch (IOException e)
        {
            System.out.println("Connection has been interrupted");
        }
    }
}

public class Server
{
    public static final int PORT = 50007;

    public static void main(String args[]) throws IOException
    {
        // creating a server socket
        ServerSocket serv;
        serv = new ServerSocket(PORT);

        // waiting for a connection and creating a network socket
        System.out.println("Listening: " + serv);
        Socket sock;
        sock = serv.accept();
        System.out.println("Connection established: " + sock);

        // creating a receiver thread
        new ReceiverThread(sock).start();

        // sending messages loop
        BufferedReader input;
        input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output;
        output = new PrintWriter(sock.getOutputStream());
        String str;
        while (true)
        {
            System.out.print("<Sending:> ");
            str = input.readLine();

            // check if the "over" or "END" message was sent
            if (str.equalsIgnoreCase("over") || str.equalsIgnoreCase("end"))
            {
                output.println(str);
                output.flush();
                break;
            }

            output.println(str);
            output.flush();
        }

        // end of communication
        System.out.println("End of connection");

        // closing the connection
        input.close();
        output.close();
        sock.close();
        serv.close();
    }
}