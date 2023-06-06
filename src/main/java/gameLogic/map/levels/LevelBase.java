package gameLogic.map.levels;

import gameLogic.map.objects.MapObjectTemplate;

import java.util.ArrayList;

public class LevelBase {
    //само поле. тут описывается платформа (земля)
    private ArrayList<ArrayList<ArrayList<MapObjectTemplate>>> levelBase = new ArrayList<>();

    private MapObjectTemplate[][][] mapObjectTemplates = new MapObjectTemplate[50][1000][1000];

    //тут находятся как препятствия, так и персонажи.

    public LevelBase () {

    }
}
