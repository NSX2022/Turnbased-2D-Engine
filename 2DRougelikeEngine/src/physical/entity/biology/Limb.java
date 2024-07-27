package physical.entity.biology;

public class Limb extends BodyComponent {
    public boolean canProsthetic = true;
    public boolean manipulator = false;

    //gigantic allows 2 handed weapons to be weilded in 1 hand/manipulator
    public boolean gigantic = false;

    //Hands are attached to arms, feet to legs
    public Limb requiredLimb = null;

    public boolean isBroken = false;

    //Stats
    public int moveBonus;
    public int armor;
}
