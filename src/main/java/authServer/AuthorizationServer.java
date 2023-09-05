package authServer;

import authServer.dbDescription.database.User;
import connectDescription.connection.SessionList;
import authServer.dbDescription.database.PGSFunctions;

import java.io.*;
import java.net.*;

public class AuthorizationServer extends Thread {
    private DatagramSocket socket;

    private SessionList sessionList;

    public AuthorizationServer(int port, SessionList sessionList) throws SocketException {
        socket = new DatagramSocket(port);
        this.sessionList = sessionList;
    }

    public void service(int port) throws IOException {
        System.out.println("Try to connect to Database");
        PGSFunctions db_archMagica = new PGSFunctions();

        db_archMagica.connect_to_db("archmagica", new User("postgres", "hasker102*Holos228"));
        if (db_archMagica.getConn() == null) {
            System.out.println("Failed to start server");
            return;
        }
        AuthorizationServerAPIAnalyzer authorizationServerApiAnalyzer = new AuthorizationServerAPIAnalyzer();

        System.out.println("Server started on port: " + port);
        while (true) {
            byte[] buf = new byte[256];
            DatagramPacket request = new DatagramPacket(buf, buf.length);
            socket.receive(request);
            String msg = new String(buf, "US-ASCII");
            System.out.println("Message: " + msg.trim());
            String answer;

            InetAddress clientAddress = request.getAddress();
            int clientPort = request.getPort();

            answer = authorizationServerApiAnalyzer.analyze(
                    msg.trim(), db_archMagica.getConn(), this.sessionList, clientAddress, clientPort);

            DatagramPacket response =
                    new DatagramPacket(answer.getBytes(), answer.length(), clientAddress, clientPort);
            socket.send(response);
        }
    }
}
