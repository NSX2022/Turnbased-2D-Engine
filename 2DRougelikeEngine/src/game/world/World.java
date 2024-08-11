package game.world;

import game.Description;
import game.GamePanel;

import java.util.ArrayList;
import java.util.Random;

public class World {
    public int worldRow = 11;
    public int worldCol = 11;
    public int worldDepth = 20;
    public String name;

    public Grid[][][] grids = new Grid[worldRow][worldCol][worldDepth];
    public GamePanel gp;
    Random rand;
    public ArrayList<Faction> worldFactions;

    //Details
    public int year = 0;

    public World(GamePanel gp) {
        this.gp = gp;
    }

    public void genWorld() {
        worldFactions = new ArrayList<>();
        rand = gp.rand;
        int dif = 0;

        Faction playerFaction = new Faction();
        Description playerFactionDesc = new Description();
        playerFactionDesc.genDesc("player");
        playerFaction.name = "Followers of playerName (TODO)";
        playerFaction.description = playerFactionDesc;

        worldFactions.add(playerFaction);

        for(int i = 0; i < worldRow; i++){
            for(int j = 0; j < worldCol; j++) {
                for(int k = 0; k < worldDepth; k++) {
                    //TODO: use perlin for biome gen
                    Grid g = new Grid(gp);
                    g.genGrid(0);
                    g.worldX = i;
                    g.worldY = j;
                    g.sectorDifficulty = dif;

                    grids[i][j][k] = g;
                    if (gp.rand.nextInt(10) <= 5) {
                        dif++;
                    }
                }
            }
        }
    }

    public void genFactions(){

    }
}
