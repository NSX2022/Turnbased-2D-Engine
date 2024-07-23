package physical.entity.biology;

import physical.item.Item;

public abstract class BodyComponent extends Item {
    public enum compStatus {OKAY, DAMAGED, DEAD};
    //Head, Brain, Heart are all vital
    public boolean isVital = false;
    public boolean isFunctional = true;
    public compStatus componentStatus = compStatus.OKAY;
    //null for no disease
    public Disease disease = null;
    //how well the component can function
    public float functionality = 1.00f;

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
