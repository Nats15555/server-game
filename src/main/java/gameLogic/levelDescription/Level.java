package gameLogic.levelDescription;

import dbDescription.database.DataBaseTableUnit;

import java.util.ArrayList;

public class Level extends DataBaseTableUnit {

    protected int level_id;
    protected String levelName;
    protected ArrayList<LevelObject> levelObjects = new ArrayList<>();

    public void addLevelObject(LevelObject levelObject) {
        levelObjects.add(levelObject);
    }

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

    public Level(int level_id, String levelName) {
        this.level_id = level_id;
        this.levelName = levelName;
    }

    public int getLevel_id() {
        return level_id;
    }
}
