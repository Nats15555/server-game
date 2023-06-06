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

public class APIAnalyzer {
    public String analyze(String jsonString, Connection connection){
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
                Session session = new Session();
                User user = apiWithDb.getUser(requestDict.fields.get("username"),
                        requestDict.fields.get("password"),connection);

                description = "Not correct username or password";
                if(user == null){ break; }
                try {
                    System.out.println(user.getHashPass());
                    System.out.println(user.hashSimple(requestDict.fields.get("password"),
                            "userSalt".getBytes(StandardCharsets.UTF_8)));
                    System.out.println(user.hashSimple(requestDict.fields.get("password"),
                            "userSalt".getBytes(StandardCharsets.UTF_8)));
                    System.out.println(user.hashSimple(requestDict.fields.get("password"),
                            "userSalt".getBytes(StandardCharsets.UTF_8)));
                    System.out.println(user.hashSimple(requestDict.fields.get("password"),
                            "userSalt".getBytes(StandardCharsets.UTF_8)));
                    System.out.println(user.hashSimple(requestDict.fields.get("password"),
                            "userSalt".getBytes(StandardCharsets.UTF_8)));
                    if (user.getHashPass() == user.hashSimple(requestDict.fields.get("password"),
                            "userSalt".getBytes(StandardCharsets.UTF_8))){
                        System.out.println("here");
                        status = "OK";
                        description = session.getSession(user.getuserName(),"JWTSalt");
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
