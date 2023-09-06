package connectDescription.connection;

import authServer.dbDescription.HashCode;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class SessionList {

    private HashMap<Integer, String> activeSessions = new HashMap<>();
    private HashMap<String, Client> clientsState = new HashMap<>();

    public void register(int id, Client client) throws Exception {
        String secret = "jwtSalt";
        Random random = new Random();

        int randomValue = random.nextInt(100000) % 2000;
        String session;
        session = HashCode.getHash(String.valueOf(randomValue), secret.getBytes(StandardCharsets.UTF_8));
        while (clientsState.get(session) != null) {
            randomValue = random.nextInt(100000) % 2000;
            session = HashCode.getHash(String.valueOf(randomValue), secret.getBytes(StandardCharsets.UTF_8));
        }

        this.activeSessions.put(id, session);
        this.clientsState.put(session, client);
    }

    public String getSession(int id) {
        return this.activeSessions.get(id);
    }
}
