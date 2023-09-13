package echoserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());
    public static void main(String[] args)  {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());


                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("/?msg=Hello")) {
                            out.write("Hello, dear friend.".getBytes());
                            System.out.println("Hello, dear friend");
                            break;
                        }
                        if (str.contains("/?msg=Exit")) {
                            server.close();
                            out.write("Server shut down".getBytes());
                            System.out.println("Server shut down");
                            break;
                        }
                        if (str.matches("[GET /?msg=].+[HTTP/1.1]")) {
                            int start = str.indexOf("=") + 1;
                            int end = str.indexOf("HTTP");
                            out.write(str.substring(start, end).getBytes());
                            System.out.println(str.substring(start, end));
                            break;
                        }

                    }
                    out.flush();
                }

            }
        } catch (IOException e) {
            LOG.error("Server port is busy", e);
        }

    }
}
