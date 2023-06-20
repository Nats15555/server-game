package servers.main;

import servers.AuthorizationServer;
import servers.api.Session;

import java.io.IOException;
import java.net.SocketException;

public class main {

    public static void main(String[] args) {
        Session session = new Session();
        System.out.println("Try to start Authorization Server");
        authorizationServerServiceStart(4445, session);
        System.out.println("Success");
    }

    public static void authorizationServerServiceStart(int authorizationServerPort, Session session) {
        try {
            AuthorizationServer server = new AuthorizationServer(authorizationServerPort, session);
            server.service(authorizationServerPort);
        } catch (SocketException ex) {
            System.out.println("Authorization Server Socket error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Authorization Server I/O error: " + ex.getMessage());
        }
        System.out.println("Authorization Server stopped");
    }
}
