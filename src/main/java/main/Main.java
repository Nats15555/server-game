package main;

import authServer.AuthorizationServer;
import authServer.dbDescription.creation.DataBaseCreation;
import connectDescription.connection.SessionList;

import java.io.IOException;
import java.net.SocketException;

public class Main {
    public static void main(String[] args) {
        boolean createDB = false;
        if (createDB) {
            DataBaseCreation dataBaseCreation = new DataBaseCreation();
            dataBaseCreation.create();
        }


        SessionList sessionList = new SessionList();
        System.out.println("Try to start Authorization Server");
        authorizationServerServiceStart(4445, sessionList);
        System.out.println("Success");
    }

    public static void authorizationServerServiceStart(int authorizationServerPort, SessionList sessionList) {
        try {
            AuthorizationServer server = new AuthorizationServer(authorizationServerPort, sessionList);
            server.service(authorizationServerPort);
        } catch (SocketException ex) {
            System.out.println("Authorization Server Socket error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Authorization Server I/O error: " + ex.getMessage());
        }
        System.out.println("Authorization Server stopped");
    }


}
