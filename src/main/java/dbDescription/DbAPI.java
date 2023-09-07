package dbDescription;

import dbDescription.database.DbObject;
import dbDescription.database.PGSFunctions;
import dbDescription.database.User;
import gameLogic.levelDescription.LevelObject;
import gameLogic.levelDescription.Level;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbAPI {
    private static PGSFunctions pgsFunctions = new PGSFunctions();

    public User getUser(String username, String password, Connection connection) {
        User user;
        try {
            user = new User(username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        DbObject dbObject = new DbObject();
        dbObject.setObj(user);
        try {
            User dbUser = (User) pgsFunctions.selectRecord(dbObject, connection).getObj();
            return dbUser;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String addUser(String username, String pass, Connection connection) {
        dbDescription.database.User user;
        DbObject dbObj = new DbObject();
        try {
            user = new User(username, pass);
            dbObj.setObj(user);
            if (pgsFunctions.selectRecord(dbObj, connection) != null) {
                return "User already exists";
            }
            DbObject dbObject = new DbObject();
            dbObject.setObj(user);
            pgsFunctions.insertRecord(dbObject, connection);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "User added";
    }

    public Level getLevel(Connection connection) {
        return null;
    }

    public ArrayList<LevelObject> getLevel(String levelName, Connection connection) {
        ArrayList<LevelObject> levelObjects = new ArrayList<>();
        return levelObjects;
    }
}
