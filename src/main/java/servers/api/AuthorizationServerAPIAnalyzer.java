package servers.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import servers.api.jsonDickts.AnswerDict;
import servers.api.jsonDickts.RequestDict;
import servers.database.User;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class AuthorizationServerAPIAnalyzer {
    public String analyze(String jsonString, Connection connection, Session session){
        Map<String, String> ans = new HashMap<String, String>();
        String description = "wrong request", method = null, status = "Bad request";

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        RequestDict requestDict = gson.fromJson(jsonString, RequestDict.class);

        APIWithDb apiWithDb = new APIWithDb();

        switch (requestDict.method){
            case "addUser":
                method = "addUser";
                if(apiWithDb.addUser(requestDict.fields.get("username"),
                        requestDict.fields.get("password"),connection) == "User added"){
                    status = "OK";
                    description = "User added";
                } else {
                    description = "User already exist";
                }
                break;
            case "getSession":
                method = "getSession";

                User user = apiWithDb.getUser(requestDict.fields.get("username"),
                        requestDict.fields.get("password"),connection);

                description = "Not correct username or password";
                if(user == null){ break; }
                try {
                    if (user.getHashPass().equals(HashCode.getHash(requestDict.fields.get("password"),
                            "userSalt".getBytes(StandardCharsets.UTF_8)))){
                        status = "OK";
                        description = session.get(user.getId());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
        }

        ans.put("description", description);
        AnswerDict answerDict = new AnswerDict(method,status,ans);

        return gson.toJson(answerDict);
    }
}
