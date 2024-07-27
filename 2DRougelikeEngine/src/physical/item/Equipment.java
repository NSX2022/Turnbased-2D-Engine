package physical.item;

public class Equipment extends Item {

    public boolean isMagic = false;
    public int durability = -1;

    public Equipment() {
        stackable = false;
    }
}
