package servers.api.level;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import authServer.dbDescription.DbAPI;
import connectDescription.jsonDickts.AnswerDict;
import connectDescription.jsonDickts.RequestDict;
import connectDescription.connection.SessionList;

import java.net.InetAddress;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class LevelAPI {
    public String analyze(String jsonString, Connection connection, SessionList sessionList, InetAddress clientAddress, int clientPort){
        Map<String, String> answerToUser = new HashMap<String, String>();
        String description = "wrong request", method = null, status = "Bad request";

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        RequestDict requestDict = gson.fromJson(jsonString, RequestDict.class);

        DbAPI dbAPI = new DbAPI();

        switch (requestDict.method){

            case "setLevel":
                method = "setLevel";

                break;
        }

        answerToUser.put("description", description);
        AnswerDict answerDict = new AnswerDict(method,status,answerToUser);

        return gson.toJson(answerDict);
    }
}
