package connectDescription.jsonDickts;

public class JWTInfo {
    private int id;
    private java.util.Date creationTime;

    public JWTInfo(int id) {
        this.id = id;
        this.creationTime = new java.util.Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.util.Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(java.util.Date creationTime) {
        this.creationTime = creationTime;
    }
}
