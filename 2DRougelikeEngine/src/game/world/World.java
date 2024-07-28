package game.world;

import game.GamePanel;

import java.util.Random;

public class World {
    public int worldRow = 11;
    public int worldCol = 11;
    public String name;

    public Grid[][] grids = new Grid[worldRow][worldCol];
    public GamePanel gp;
    Random rand;

    //Details
    public int year = 0;

    public World(GamePanel gp) {
        this.gp = gp;
    }

    public void genWorld() {
        rand = gp.rand;
        for(int i = 0; i < worldRow; i++){
            for(int j = 0; j < worldCol; j++) {
                //TODO: use perlin for biome gen
                Grid g = new Grid(gp);
                g.genGrid(0);
                grids[i][j] = g;
            }
        }
    }
}
