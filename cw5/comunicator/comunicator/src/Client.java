import java.io.*;
import java.net.*;

public class Client
    {
    public static final int PORT=50007;
    public static final String HOST = "127.0.0.1";
    public static void main(String[] args)
    {
        try {
            // establishing a connection with the server
            Socket sock;
            sock = new Socket(HOST,PORT);
            System.out.println("Connection established: " + sock);

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
                if(str.equalsIgnoreCase("end")) {
                    System.out.println("End of connection");
                    break;
                }
            }

            //closing the connection
            keys.close();
            outp.close();
            sock.close();
        } catch (ConnectException e) {
            System.out.println("Connection has been interrupted");
        } catch (SocketException e) {
            System.out.println("TCP-related error occurred");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}