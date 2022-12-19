import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

class HttpServer {
    private static final int PORT = 8080;
    private static final String SERVER_ROOT = System.getProperty("user.dir") + "/java-course/task-6/HTTP/ServerHTTP/src/";
    private static final String NOT_FOUND_PAGE = "404.html";
    private static final String NOT_FOUND_MESSAGE = "HTTP/1.0 404 File Not Found\r\nContent-Type: text/html\r\nContent-Length: %d\r\n\r\n";
    private static final String BAD_REQUEST_MESSAGE = "HTTP/1.0 400 Bad Request\r\nContent-Type: text/html\r\nContent-Length: %d\r\n\r\n";
    private static final String OK_MESSAGE = "HTTP/1.0 200 OK\r\nContent-Type: %s\r\nContent-Length: %d\r\n\r\n";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(() -> {
                try {
                    handleRequest(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static void handleRequest(Socket clientSocket) throws IOException {
        InputStream inputStream = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        OutputStream outputStream = clientSocket.getOutputStream();
        DataOutputStream writer = new DataOutputStream(outputStream);

        String request = reader.readLine();
        System.out.println(request);

        String[] parts = request.split(" ");
        if (parts.length != 3 || !parts[0].equals("GET")) {
            sendErrorResponse(writer, BAD_REQUEST_MESSAGE, "Bad Request");
            return;
        }

        String filePath = SERVER_ROOT + parts[1];
        File file = new File(filePath);
        if (!file.exists()) {
            file = new File(SERVER_ROOT + NOT_FOUND_PAGE);
            sendErrorResponse(writer, NOT_FOUND_MESSAGE, "File Not Found");
        }
        else {
            String contentType = Files.probeContentType(file.toPath());
            if (contentType == null) {
                contentType = "application/octet-stream";
            }
            sendOkResponse(writer, file, contentType);
        }

        reader.close();
        writer.close();
        clientSocket.close();
    }

    private static void sendErrorResponse(DataOutputStream writer, String messageFormat, String errorMessage) throws IOException {
        byte[] errorPage = Files.readAllBytes(new File(SERVER_ROOT + NOT_FOUND_PAGE).toPath());
        String response = String.format(messageFormat, errorPage.length);
        writer.writeBytes(response);
        writer.write(errorPage);
    }

    private static void sendOkResponse(DataOutputStream writer, File file, String contentType) throws IOException {
        byte[] fileContent = Files.readAllBytes(file.toPath());
        String response = String.format(OK_MESSAGE, contentType, fileContent.length);
        writer.writeBytes(response);
        writer.write(fileContent);
    }
}
