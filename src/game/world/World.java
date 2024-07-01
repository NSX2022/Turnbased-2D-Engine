package game.world;

import game.GamePanel;

public class World {
    public int worldRow = 11;
    public int worldCol = 11;

    public Grid[][] grids = new Grid[worldRow][worldCol];
    public GamePanel gp;

    public World(GamePanel gp) {
        this.gp = gp;
    }

    public void genWorld() {
        for(int i = 0; i < worldRow; i++){
            for(int j = 0; j < worldCol; j++) {
                //TODO
                //grids[i][j] =
            }
        }
    }
}
