package authServer.dbDescription.database.enams;

public enum BdRequests {
    INSERT_INTO_USERS("INSERT INTO users (username, password, created_on, last_login) VALUES (?, ?, ?, ?);"),
    SELECT_FROM_USERS("SELECT id, username, password FROM users WHERE username = ?;"),

    INSERT_INTO_LEVELS("INSERT INTO level_objects (level_name) VALUES (?);"),
    SELECT_FROM_LEVELS("SELECT level_id FROM levels WHERE level_name = ?;"),
    INSERT_INTO_LEVEL_OBJECTS("INSERT INTO level_objects (owner_id, level_object_info) VALUES (?, ?);"),
    SELECT_FROM_LEVEL_OBJECTS("SELECT level_object_id, level_object_info WHERE owner_id = ?;");
    public String request;

    BdRequests(String request) {
        this.request = request;
    }
}
