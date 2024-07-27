package physical.entity.biology;

import physical.item.Item;

import java.util.ArrayList;

public abstract class BodyComponent extends Item {
    public enum compStatus {OKAY, DAMAGED, DEAD};
    //Head, Brain, Heart are all vital
    public boolean isVital = false;
    public boolean isFunctional = true;
    public compStatus componentStatus = compStatus.OKAY;
    //null for no disease
    public ArrayList<Disease> diseases;
    public ArrayList<Injury> injuries;
    //how well the component can function = hp/maxHp
    public int maxHp;
    public int hp;

    //stats
    public int baseArmor;

    //misc
    public String name;


    @Override
    public String toString() {
        String status = switch (componentStatus) {
            case DEAD -> "dead";
            case OKAY -> "healthy";
            case DAMAGED -> "damaged";
        };

        return name + ": " + status;
    }
}