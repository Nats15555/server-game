package gameLogic.levelDescriptors.levels;

import authServer.dbDescription.creation.DataBaseCreation;
import authServer.dbDescription.database.DataBaseTableUnit;
import gameLogic.levelDescriptors.LevelObject;

import java.util.ArrayList;

public class Level extends DataBaseTableUnit {

    protected String levelName;
    protected ArrayList<LevelObject> levelObjects = new ArrayList<>();

    public ArrayList<LevelObject> getLevelObjects() {
        return levelObjects;
    }

    public void setLevelObjects(ArrayList<LevelObject> levelObjects) {
        this.levelObjects = levelObjects;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Level(ArrayList<LevelObject> levelObjects) {
        this.levelObjects = levelObjects;
    }

    public Level() {

    }
}
