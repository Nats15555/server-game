package servers.database;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;

public class User extends DataBaseTableUnit {
    private int id;
    private String userName;
    private String hashPass;
    public String hashSimple(String password, byte[] salt) throws Exception{
        //функция работает не верно
        //функция каждый раз с той же солью генерирует новый хэш, а не старый. что делает невозможным проверку.
        //изменить.
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        return String.valueOf(hash);
    }

    public User(String userName, String pass) throws Exception {
        setUnitName("User");
        this.userName = userName;
        this.hashPass = this.hashSimple(pass, "userSalt".getBytes(StandardCharsets.UTF_8));

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
