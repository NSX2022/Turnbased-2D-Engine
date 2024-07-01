package physical.entity.biology;

public class Limb extends BodyComponent {
    public boolean canProsthetic = true;
    public boolean manipulator = false;

    //Hands are attached to arms, feet to legs
    public Limb requiredLimb = null;

    public boolean isBroken = false;
}
