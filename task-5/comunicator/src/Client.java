import java.io.*;
import java.net.*;

public class Client
{
    public static final int PORT=50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args)
    {
       try
       {
           // establishing a connection with the server
           Socket socket;
           socket = new Socket(HOST, PORT);
           System.out.println("Connection established: " + socket);

           // create streams of data taken from the keyboard and delivered to the socket
           BufferedReader input;
           input = new BufferedReader(new InputStreamReader(System.in));
           PrintWriter output;
           output = new PrintWriter(socket.getOutputStream());

           // communication loop
           String str;
           while (true)
           {
               System.out.print("<Sending:> ");
               str = input.readLine();

               // check if the "end" or "END" message was sent
               if (str.equalsIgnoreCase("end"))
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
           socket.close();
       }
       catch (SocketException e)
       {
           System.out.println("There was an error with the socket: " + e.getMessage());
       }
       catch (IOException e)
       {
           System.out.println("Connection has been interrupted");
       }
    }
}
