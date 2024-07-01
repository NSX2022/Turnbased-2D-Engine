package game.world;

import physical.entity.Entity;
import physical.item.Item;

public class Grid {
    public GridEntity[][] gridEntities;
    public Item[][][] droppedItems;
    public Entity[][] entities;

    public int sectorDifficulty;
    public float perlinValue;

    public static final int rows = 15;
    public static final int cols = rows;
}
