package physical.item;

import physical.entity.StatSheet;

public class Equipment extends Item {

    public boolean isMagic = false;
    public int durability = -1;

    public StatSheet statBonuses;

    public Equipment() {
        stackable = false;
    }
}
