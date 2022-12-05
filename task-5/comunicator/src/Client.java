import java.io.*;
import java.net.*;

public class Client
{
    public static final int PORT=50007;
    public static final String HOST = "127.0.0.1";
    public static void main(String[] args) throws IOException
    {
        // establishing a connection with the server
        Socket socket;
        socket = new Socket(HOST,PORT);
        System.out.println("Connection established: " + socket);

        // create streams of data taken from the keyboard and delivered to the socket
        BufferedReader keys;
        keys=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter outp;
        outp=new PrintWriter(socket.getOutputStream());

        //communication - reading data from the keyboard and passing it to the stream
        String str;
        while ((str = keys.readLine()) != null) {
            System.out.print("<Sending:> ");
            outp.println(str);
            outp.flush();
    }

    //closing the connection
    keys.close();
    outp.close();
    socket.close();
}
}