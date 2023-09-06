package authServer.dbDescription.creation;

import java.sql.*;

public class DataBaseCreation {

    private Connection conn = null;
    private Statement stmt = null;

    private String dbName, username, pass;

    public void create(){
        dbName = "archmagica";
        username = "postgres";
        pass = "hasker102*Holos228";
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + this.dbName, this.username, this.pass);
            stmt = conn.createStatement();
            String users = "CREATE TABLE users " +
                    "(user_id serial PRIMARY KEY, " +
                    " username CHAR(50) UNIQUE NOT NULL, " +
                    " password VARCHAR(1024) NOT NULL, " +
                    " created_on TIMESTAMP NOT NULL, " +
                    " last_login TIMESTAMP)";

            String levels = "CREATE TABLE levels " +
                    "(level_id serial PRIMARY KEY, " +
                    " level_name CHAR(20) UNIQUE NOT NULL)";

            String level_objects = "CREATE TABLE level_objects " +
                    "(level_object_id serial PRIMARY KEY, " +
                    " owner_id INT NOT NULL, " +
                    " level_object_info json NOT NULL)";

            // создаем по одной таблице за раз, просто меняем необходимую таблицу
            stmt.executeUpdate(level_objects);
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
