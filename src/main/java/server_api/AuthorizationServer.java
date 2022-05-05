package server_api;

public class AuthorizationServer {
    private String GenerateJWT(int id, String secretKey){
        String jwt;
        jwt = "null";

        return jwt;
    }

    private String EncodeJWT (String JWTString){
        String EncodedJWTString = "null";
        return EncodedJWTString;
    }

    public String GetSession(String login, String pass){
        int id;
        String secretKey;
        id = 0;
        secretKey = "null";
        return GenerateJWT(id,secretKey);
    }
}
