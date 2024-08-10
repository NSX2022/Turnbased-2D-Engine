package game;

import game.world.Faction;
import game.world.Grid;
import game.world.GridEntity;
import game.world.Tile;
import physical.entity.Entity;
import physical.entity.StatSheet;

import java.util.ArrayList;
import java.util.Objects;

public class Description {

    private ArrayList<String> desc;
    //Required stats to understand the description
    public StatSheet statReqs;

    public Description(){
        statReqs = new StatSheet();
        statReqs.arc = 0;
        statReqs.dex = 0;
        statReqs.mind = 0;
        statReqs.str = 0;
        statReqs.perc = 0;
        statReqs.vit = 0;
    }

    public void genDesc(Object object){
        if(object.getClass().equals(Tile.class)){

        }else if(object.getClass().equals(Grid.class)) {

        }else if(object.getClass().equals(Faction.class)){

        }else if(object.getClass().equals(Entity.class)){

        }
    }

    public String getDesc(){
        StringBuilder toRet = new StringBuilder();

        for(String s:desc){
            toRet.append(" ").append(s);
        }

        return toRet.toString();
    }
}
