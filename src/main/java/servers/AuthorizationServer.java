package servers;

import servers.api.APIAnalyzer;
import servers.database.PGSFunctions;

import java.io.*;
import java.net.*;

public class AuthorizationServer extends Thread {
    private DatagramSocket socket;

    public AuthorizationServer(int port) throws SocketException { socket = new DatagramSocket(port); }

    public static void main(String[] args) {
        int port = 4445;
        try {
            AuthorizationServer server = new AuthorizationServer(port);
            server.service(port);
        } catch (SocketException ex) {
            System.out.println("Socket error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
        System.out.println("Server stopped");
    }

    private void service(int port) throws IOException {
        System.out.println("Try to connect to Database");
        PGSFunctions db_archMagica = new PGSFunctions();
        db_archMagica.connect_to_db("archmagica","postgres","");
        if (db_archMagica.getConn() == null){
            System.out.println("Failed to start server");
            return;
        }
        APIAnalyzer apiAnalyzer = new APIAnalyzer();

        System.out.println("Server started on port: " + port);
            while (true) {
                byte[] buf = new byte[256];
                DatagramPacket request = new DatagramPacket(buf, buf.length);
                socket.receive(request);
                String msg = new String(buf, "US-ASCII");
                System.out.println("Message: " + msg.trim());
                String answer;
                answer = apiAnalyzer.analyze(msg.trim(), db_archMagica.getConn());

                InetAddress clientAddress = request.getAddress();
                int clientPort = request.getPort();

                DatagramPacket response =
                        new DatagramPacket(answer.getBytes(), answer.length(), clientAddress, clientPort);
                socket.send(response);
            }
    }
}
