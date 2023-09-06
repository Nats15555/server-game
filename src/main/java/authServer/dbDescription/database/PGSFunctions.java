package authServer.dbDescription.database;

import authServer.dbDescription.database.enams.BdRequests;
import gameLogic.levelDescriptors.LevelObject;
import gameLogic.levelDescriptors.levels.Level;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.*;
import java.util.logging.Logger;

public class PGSFunctions {
    private Connection conn = null;
    private String salt = "baseSalt";

    private void connect_to_db(String dbname, String username, String pass) {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, username, pass);
            if (conn == null) {
                System.out.println("Connection Failed");
                return;
            }
            System.out.println("Connection Established");
        } catch (Exception e) {
            Logger logger = Logger.getLogger("TrainingLogger");
            logger.info(String.valueOf(e));
            System.out.println(e);
        }
    }

    public void connect_to_db(String dbName, User user) {
        connect_to_db(dbName, user.getuserName(), user.getPassword());
    }

    public void insertRecord(DbObject dbObject, Connection connection) throws SQLException {
        if (connection == null) {
            System.out.println("No connection to database");
            return;
        }
        switch (dbObject.getObjName()) {
            case "User":
                User user = (User) dbObject.getObj();

                //приведение даты
                java.util.Date utilPackageDate = new java.util.Date();
                java.sql.Date sqlPackageDate = new java.sql.Date(utilPackageDate.getTime());

                // добавление пользователя
                PreparedStatement userPreparedStatement = connection.prepareStatement(BdRequests.INSERT_INTO_USERS.request);
            {
                userPreparedStatement.setString(1, user.getuserName());
                userPreparedStatement.setString(2, user.getHashPass());
                userPreparedStatement.setDate(3, sqlPackageDate);
                userPreparedStatement.setDate(4, sqlPackageDate);
                userPreparedStatement.executeUpdate();
            }
            break;
            case "Level":
                Level level = (Level) dbObject.getObj();
                PreparedStatement levelPreparedStatement = connection.prepareStatement(BdRequests.INSERT_INTO_LEVELS.request);
            {
                levelPreparedStatement.setString(1, level.getLevelName());
                levelPreparedStatement.executeUpdate();
            }
            break;
            case "LevelObject":
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();

                LevelObject levelObject = (LevelObject) dbObject.getObj();
                PreparedStatement levelObjectPreparedStatement = connection.prepareStatement(BdRequests.INSERT_INTO_LEVEL_OBJECTS.request);
            {
                levelObjectPreparedStatement.setInt(1, levelObject.getObjectOwner());
                levelObjectPreparedStatement.setString(2, gson.toJson(levelObject));
                levelObjectPreparedStatement.executeUpdate();
            }
            break;

            default:
                throw new IllegalStateException("Unexpected value: " + dbObject.getObjName());
        }
    }

    public DbObject selectRecord(DbObject dbObject, Connection connection) throws SQLException {
        if (connection == null) {
            System.out.println("No connection to database");
            return null;
        }
        DbObject dbObj = new DbObject();
        switch (dbObject.getObjName()) {
            case "User":
                User user = (User) dbObject.getObj();
                // извлечение пользователя
                PreparedStatement preparedStatement = connection.prepareStatement(BdRequests.SELECT_FROM_USERS.request);
            {
                preparedStatement.setString(1, user.getuserName());
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    User u = null;
                    try {
                        u = new User(username, password);
                        u.setId(id);
                        u.setHashPass(password);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    dbObj.setObj(u);
                    return dbObj;
                }
                break;
            }
        }
        return null;
    }

    public Connection getConn() {
        return conn;
    }
}
