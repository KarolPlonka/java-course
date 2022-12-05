import java.io.*;
import java.net.*;

public class Client
{
public static final int PORT=50007;
public static final String HOST = "127.0.0.1";

public static void main(String[] args) throws IOException
{
    // establishing a connection with the server
    Socket sock;
    sock = new Socket(HOST,PORT);
    System.out.println("Connection established: " + sock);

    // create a receiving thread
    new Receive(sock).start();

    // create streams of data taken from the keyboard and delivered to the socket
    BufferedReader keys;
    keys = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter outp;
    outp = new PrintWriter(sock.getOutputStream());

    //communication - reading data from the keyboard and passing it to the stream
    String str;
    while ((str = keys.readLine()) != null) {
        System.out.print("<Sending:> ");
        outp.println(str);
        outp.flush();

        // check if "over" or "END" was sent and end communication if so
        if (str.equalsIgnoreCase("over") || str.equalsIgnoreCase("END")) {
            break;
        }
    }

    // print end of connection message
    System.out.println("End of connection");

    //closing the connection
    keys.close();
    outp.close();
    sock.close();
}
}

class Receive extends Thread
{
    Socket sock;
    BufferedReader sockReader;

    public Receive(Socket sock) throws IOException
    {
        this.sock = sock;
        this.sockReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }

    public void run()
    {
        // receive messages from the server
        String str;
        try {
            while ((str = sockReader.readLine()) != null) {
                System.out.println("<Received:> " + str);

                // check if "over" or "END" was received and end communication if so
                if (str.equalsIgnoreCase("over") || str.equalsIgnoreCase("END")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // print end of connection message
        System.out.println("End of connection");
    }
}