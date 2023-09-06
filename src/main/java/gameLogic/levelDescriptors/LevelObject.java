package gameLogic.levelDescriptors;

import authServer.dbDescription.database.DataBaseTableUnit;
import gameLogic.levelDescriptors.enams.LevelObjectType;

public class LevelObject extends DataBaseTableUnit {
    public double positionX, positionY, positionZ;
    public int rotationX, rotationY, rotationZ;
    public double scaleX, scaleY, scaleZ;

    private int objectOwner;

    private LevelObjectType levelObjectType;

    public LevelObject() {
        setUnitName("LevelObject");
    }

    public void AddPosition(double X, double Y, double Z) {
        this.positionX += X;
        this.positionY += Y;
        this.positionZ += Z;
    }

    public void AddPosition(Vector3 position) {
        this.positionX += position.x;
        this.positionY += position.y;
        this.positionZ += position.z;
    }

    public void SetPosition(double X, double Y, double Z) {
        this.positionX = X;
        this.positionY = Y;
        this.positionZ = Z;
    }

    public void SetPosition(Vector3 position) {
        this.positionX = position.x;
        this.positionY = position.y;
        this.positionZ = position.z;
    }

    public void AddRotation(double X, double Y, double Z) {
        this.rotationX += X;
        this.rotationY += Y;
        this.rotationZ += Z;
    }

    public void AddRotation(Vector3 rotation) {
        this.rotationX += rotation.x;
        this.rotationY += rotation.y;
        this.rotationZ += rotation.z;
    }

    public void SetRotation(int X, int Y, int Z) {
        this.rotationX = X;
        this.rotationY = Y;
        this.rotationZ = Z;
    }

    public void SetRotation(Vector3 rotation) {
        this.rotationX = (int) rotation.x;
        this.rotationY = (int) rotation.y;
        this.rotationZ = (int) rotation.z;
    }

    public void SetScale(double X, double Y, double Z) {
        this.scaleX = X;
        this.scaleY = Y;
        this.scaleZ = Z;
    }

    public void SetScale(Vector3 scale) {
        this.scaleX = scale.x;
        this.scaleY = scale.y;
        this.scaleZ = scale.z;
    }

    public int getObjectOwner() {
        return objectOwner;
    }

    public void setObjectOwner(int objectOwner) {
        this.objectOwner = objectOwner;
    }
}
