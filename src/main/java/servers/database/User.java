package servers.database;

import servers.api.HashCode;

import java.nio.charset.StandardCharsets;


public class User extends DataBaseTableUnit {
    private int id;
    private String userName;
    private String hashPass;

    public User(String userName, String pass) throws Exception {
        setUnitName("User");
        this.userName = userName;
        this.hashPass = HashCode.getHash(pass, "userSalt".getBytes(StandardCharsets.UTF_8));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String username) {
        this.userName = username;
    }

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) throws Exception {
        this.hashPass = hashPass;
    }

}
