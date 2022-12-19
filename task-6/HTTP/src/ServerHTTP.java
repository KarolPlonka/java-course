import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Optional;

class Serve extends Thread
{
    Socket clientSocket;
    FileWriter logFile;

    static int counter = 0;

    Serve(Socket sock, FileWriter file)
    {
        this.clientSocket = sock;
        this.logFile = file;
        counter++;
    }

    void task() throws IOException {
        //strumienie danych
        InputStream is;
        OutputStream os;
        try {
            is = clientSocket.getInputStream();
            os = clientSocket.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader inp = new BufferedReader(new InputStreamReader(is));
        DataOutputStream outp = new DataOutputStream(os);

        //przyjecie zadania (request)
        String request= null;
        try {
            request = inp.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (request == null)
        {
            return;
        }

        //saving log
        Date date = new Date();
        String log = date.toString() + "\t" + request + "\t" + this.clientSocket.getInetAddress().toString() + "\n";
        this.logFile.write(log);
        this.logFile.flush();

        System.out.println(request);
        String fileName = request.split(" ")[1];
        System.out.println("file: " + fileName);

        String code = "HTTP/1.0 200 OK\r\n";
        FileInputStream file;

        try {
            file = new FileInputStream(new File(System.getProperty("user.dir") + "/java-course/task-6/HTTP/ServerHTTP/src/" + fileName));
        }
        catch (FileNotFoundException e) {
            try {
                file = new FileInputStream(new File(System.getProperty("user.dir") + "/java-course/task-6/HTTP/ServerHTTP/src/404.html"));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            code = "HTTP/1.0 404 FileNotFound\r\n";
        }

        byte[] buf;
        buf = new byte[1024];
        int n = 0;

        int contentLength = 0;
        try {
            contentLength = file.available();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String extension = Optional.ofNullable(fileName).filter(f -> f.contains(".")).map(f -> f.substring(fileName.lastIndexOf(".") + 1)).get();
        System.out.println("extension: " + extension);

        //wyslanie odpowiedzi (response)
        if(request.startsWith("GET"))
        {
            //response header
            outp.writeBytes(code);
            if (extension.equals("html"))
            {
                outp.writeBytes("Content-Type: text/html\r\n");
            }
            else
            {
                outp.writeBytes("Content-Type: \r\n");
            }
            outp.writeBytes("Content-Length: " + contentLength + "\r\n");
            outp.writeBytes("\r\n");

            while ((n = file.read(buf)) != -1)
            {
                outp.write(buf);
            }
        }
        else
        {
            outp.writeBytes("HTTP/1.1 501 Not supported.\r\n");
        }

            /*while (inp.ready())
            {
                System.out.println(request);
                request = inp.readLine();
            }*/

        //zamykanie strumieni
        inp.close();
        outp.close();
        this.clientSocket.close();

        System.out.println("Ilosc threadow: " + counter);
    }

    public void run()
    {
        try {
            task();
        }
        catch (IOException e) {
            return;}
    }
}

public class ServerHTTP
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose port number: ");
        int port = Integer.parseInt(br.readLine());
        ServerSocket serv;
        while (true)
        {
            try {
                serv=new ServerSocket(port);
                break;
            }
            catch (BindException e)
            {
                System.out.println("Selected port in use, choose another: ");
                port = Integer.parseInt(br.readLine());
            }
        }

        //creating log file
        FileWriter file = new FileWriter(new File("log.txt"));

        while(true)
        {
            //przyjecie polaczenia
            System.out.println("Oczekiwanie na polaczenie...");
            Socket sock=serv.accept();

            new Serve(sock, file).start();
        }
    }
}