package authServer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import authServer.dbDescription.DbAPI;
import authServer.dbDescription.HashCode;
import connectDescription.jsonDickts.AnswerDict;
import connectDescription.jsonDickts.RequestDict;
import connectDescription.connection.Client;
import connectDescription.connection.SessionList;
import authServer.dbDescription.database.User;

import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class AuthorizationServerAPIAnalyzer {
    public String analyze(String jsonString, Connection connection, SessionList sessionList, InetAddress clientAddress, int clientPort) {
        Map<String, String> answerToUser = new HashMap<String, String>();
        String description = "wrong request", method = null, status = "Bad request";

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        RequestDict requestDict = gson.fromJson(jsonString, RequestDict.class);

        DbAPI dbAPI = new DbAPI();

        switch (requestDict.method) {
            case "addUser":
                method = "addUser";
                if (dbAPI.addUser(requestDict.fields.get("username"),
                        requestDict.fields.get("password"), connection) == "User added") {
                    status = "OK";
                    description = "User added";
                } else {
                    description = "User already exist";
                }
                break;
            case "getSession":
                method = "getSession";

                User user = dbAPI.getUser(requestDict.fields.get("username"),
                        requestDict.fields.get("password"), connection);

                description = "Not correct username or password";
                if (user == null) {
                    break;
                }
                try {
                    if (user.getHashPass().equals(HashCode.getHash(requestDict.fields.get("password"),
                            "userSalt".getBytes(StandardCharsets.UTF_8)))) {
                        status = "OK";
                        sessionList.register(user.getId(), new Client(clientAddress, clientPort));
                        description = sessionList.getSession(user.getId());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
        }

        answerToUser.put("description", description);
        AnswerDict answerDict = new AnswerDict(method, status, answerToUser);

        return gson.toJson(answerDict);
    }
}
