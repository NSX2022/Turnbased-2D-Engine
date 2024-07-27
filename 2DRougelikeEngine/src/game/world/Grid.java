package game.world;

import game.GamePanel;
import physical.entity.Entity;
import physical.item.Item;

import java.awt.*;

public class Grid {

    public int sectorDifficulty;
    public float perlinValue;

    public static final int rows = 15;
    public static final int cols = rows;

    public Tile[][] tiles = new Tile[rows][cols];

    public int worldX, worldY;

    GamePanel gp;

    public Grid(GamePanel gp){
        this.gp = gp;
    }

    public void genGrid(int gType){
        Tile t;
        switch (gType) {
            //create a flat grid of a material
            case 0:
                //Ground
                for(int i = 0; i < rows; i++){
                    for(int j = 0; j < cols; j++){
                        t = Tile.newTile(0);
                        t.gridX = i;
                        t.gridY = j;
                        tiles[i][j] = t;
                    }
                }
                break;
            case 1:
                //Stone
                for(int i = 0; i < rows -1; i++){
                    for(int j = 0; j < cols -1; j++){
                        t = Tile.newTile(1);
                        t.gridX = i;
                        t.gridY = j;
                        tiles[i][j] = t;
                    }
                }
                break;
            case 2:
                break;
        }
        //TODO: add plants/enemies/etc.
    }

    public void draw(Graphics g) {

    }
}
