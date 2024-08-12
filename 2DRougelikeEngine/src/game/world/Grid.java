package game.world;

import game.Description;
import game.GamePanel;
import physical.entity.Entity;
import physical.item.Item;

import java.awt.*;

public class Grid {

    public int sectorDifficulty;
    public float perlinValue;

    public static final int rows = 48;
    public static final int cols = rows;

    public Tile[][] tiles = new Tile[rows][cols];

    public int worldX, worldY;

    GamePanel gp;

    public Description description;

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
                        t = Tile.newTile(0, gp);
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
                        t = Tile.newTile(1, gp);
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

        //Finalize

    }

    public void addEntity(int x, int y, int entId){
        if(x == -1 && y == -1){
            //Random position

        }
    }

    public void draw(Graphics g){
        for(int i = 0; i < rows-1; i++){
            for(int j = 0; j < cols-1; j++){
                tiles[i][j].draw(g);
            }
        }
    }

    public Point getClearTile(int x, int y){
        Point toRet = new Point();
        if(x == -1 && y == -1){
            //Random position

        }

        return toRet;
    }
}
