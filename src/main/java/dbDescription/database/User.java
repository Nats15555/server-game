package dbDescription.database;

import dbDescription.HashCode;

import java.nio.charset.StandardCharsets;


public class User extends DataBaseTableUnit {
    private int id;
    private String userName;
    private String password;
    private String hashPassword;

    public String getPassword() {
        return password;
    }

    public User(String userName, String password) {
        setUnitName("User");
        this.userName = userName;
        this.password = password;
        try {
            doHashPassword();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void doHashPassword() throws Exception {
        this.hashPassword = HashCode.getHash(this.password, "userSalt".getBytes(StandardCharsets.UTF_8));
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

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getHashPass() {
        return hashPassword;
    }

    public void setHashPass(String hashPass) throws Exception {
        this.hashPassword = hashPass;
    }

}
