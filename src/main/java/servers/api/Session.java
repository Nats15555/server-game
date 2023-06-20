package servers.api;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Session {

    HashMap<Integer, String> activeSessions = new HashMap<>();
    public void register(int id) throws Exception {
        String secret = "jwtSalt";
        Random random = new Random();
        int randomValue = random.nextInt(100000) % 2000;
        this.activeSessions.put(id,HashCode.getHash(String.valueOf(randomValue),secret.getBytes(StandardCharsets.UTF_8)));
    }

    public String get(int id) throws Exception {
        if (this.activeSessions.get(id) == null)
            this.register(id);
        return this.activeSessions.get(id);
    }
}
