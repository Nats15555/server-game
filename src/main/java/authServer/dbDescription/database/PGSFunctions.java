package authServer.dbDescription.database;

import java.sql.*;
import java.util.Calendar;
import java.util.logging.Logger;

public class PGSFunctions {
    //Insert Strings
    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (username, password, created_on, last_login) VALUES " +
            " (?, ?, ?, ?);";
    private static final String SELECT_USER_QUERY = "SELECT id, username, password FROM users WHERE username = ?";
    private Connection conn = null;
    private String salt = "baseSalt";
    private void connect_to_db(String dbname, String username, String pass){
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname,username,pass);
            if (conn == null){
                System.out.println("Connection Failed");
                return;
            }
            System.out.println("Connection Established");
        }catch (Exception e){
            Logger logger = Logger.getLogger("TrainingLogger");
            logger.info(String.valueOf(e));
            System.out.println(e);
        }
    }

    public void connect_to_db(String dbName, User user){
        connect_to_db(dbName, user.getuserName(), user.getHashPass());
    }

    public void insertRecord(DbObject dbObject, Connection connection) throws SQLException {
        if (connection == null){
            System.out.println("No connection to database");
            return;
        }
        switch (dbObject.getObjName()){
            case "User":
                User user = (User) dbObject.getObj();
                Calendar calendar = Calendar.getInstance();

                //приведение даты
                java.util.Date utilPackageDate = new java.util.Date();
                java.sql.Date sqlPackageDate = new java.sql.Date(utilPackageDate.getTime());

                // добавление пользователя
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);{
                preparedStatement.setString(1, user.getuserName());
                preparedStatement.setString(2,user.getHashPass());
                preparedStatement.setDate(3,sqlPackageDate);
                preparedStatement.setDate(4,sqlPackageDate);
                preparedStatement.executeUpdate();
            }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dbObject.getObjName());
        }
    }

    public DbObject selectRecord(DbObject dbObject, Connection connection) throws SQLException{
        if (connection == null){
            System.out.println("No connection to database");
            return null;
        }
        DbObject dbObj = new DbObject();
        switch (dbObject.getObjName()){
            case "User":
                User user = (User) dbObject.getObj();
                // извлечение пользователя
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_QUERY); {
                preparedStatement.setString(1, user.getuserName());
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    User u = null;
                    try {
                        u = new User(username,password);
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
