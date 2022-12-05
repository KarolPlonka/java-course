import java.io.*;
import java.net.*;

class Send extends Thread
{
    Socket socket;
    BufferedReader userInput;
    PrintWriter sockWriter;

    public Send(Socket sock) throws IOException
    {
        this.socket = sock;
        this.userInput = new BufferedReader(new InputStreamReader(System.in));
        this.sockWriter = new PrintWriter(sock.getOutputStream());
    }

    public void run()
    {
        try {
            String message;
            while ((message = userInput.readLine()) != null) {
                // Send the message entered by the user to the server or client
                sockWriter.println(message);
                sockWriter.flush();

                
            // If the sent message is "over" or "END", end the connection
            if (message.equals("over") || message.equals("END")) {
                System.out.println("End of connection");
                break;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}