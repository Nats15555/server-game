package enginePhysicsCore;

import enginePhysicsCore.enams.LevelObjectType;

public class LevelObject {
    public float positionX, positionY, positionZ;
    public int rotationX, rotationY, rotationZ;
    public float scaleX, scaleY, scaleZ;

    private LevelObjectType levelObjectType;

    public void AddPosition (float X, float Y, float Z){
        this.positionX += X;
        this.positionY += Y;
        this.positionZ += Z;
    }

    public void AddPosition (Vector3 position){
        this.positionX += position.x;
        this.positionY += position.y;
        this.positionZ += position.z;
    }

    public void SetPosition (float X, float Y, float Z){
        this.positionX = X;
        this.positionY = Y;
        this.positionZ = Z;
    }

    public void SetPosition (Vector3 position){
        this.positionX = position.x;
        this.positionY = position.y;
        this.positionZ = position.z;
    }

    public void AddRotation (float X, float Y, float Z){
        this.rotationX += X;
        this.rotationY += Y;
        this.rotationZ += Z;
    }

    public void AddRotation (Vector3 rotation){
        this.rotationX += rotation.x;
        this.rotationY += rotation.y;
        this.rotationZ += rotation.z;
    }

    public void SetRotation (int X, int Y, int Z){
        this.rotationX = X;
        this.rotationY = Y;
        this.rotationZ = Z;
    }

    public void SetRotation (Vector3 rotation){
        this.rotationX = (int) rotation.x;
        this.rotationY = (int) rotation.y;
        this.rotationZ = (int) rotation.z;
    }

    public void SetScale (float X, float Y, float Z){
        this.scaleX = X;
        this.scaleY = Y;
        this.scaleZ = Z;
    }

    public void SetScale (Vector3 scale){
        this.scaleX = scale.x;
        this.scaleY = scale.y;
        this.scaleZ = scale.z;
    }

}
