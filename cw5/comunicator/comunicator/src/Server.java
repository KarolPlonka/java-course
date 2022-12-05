import java.io.*;
import java.net.*;

public class Server
{
    public static final int PORT=50007;

    public static void main(String[] args) throws IOException
    {
        // creating a server socket
        ServerSocket serv;
        serv = new ServerSocket(PORT);
        System.out.println("Server started: " + serv);

        // wait for incoming connections
        Socket sock;
        sock = serv.accept();
        System.out.println("Connection accepted: " + sock);

        // create streams of data taken from the socket and delivered to the keyboard
        BufferedReader inp;
        inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter outp;
        outp = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()), true);

        //communication - receiving and sending data
        String str;
        while ((str = inp.readLine()) != null) {
            System.out.println("<Received:> " + str);
            if(str.equalsIgnoreCase("end")) {
                System.out.println("End of connection");
                break;
            }
        }

        //closing the connection
        inp.close();
        outp.close();
        sock.close();
        serv.close();
    }
}