package spell;

import java.util.Objects;

public class SpellObject {
    private int sizeX, sizeY, sizeZ;

    // мб объединить в вектор
    private int posX, posY, posZ;

    private int concentration;
    private int energyType;
    private int shapeType;


    public void setShapeType(int shapeType) {
        this.shapeType = shapeType;
    }

    public void setEnergyType(int energyType) {
        this.energyType = energyType;
    }

    public void setSize(int sizeX, int sizeY, int sizeZ){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
    }

    public void setPos(int posX, int posY, int posZ){
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }
}
