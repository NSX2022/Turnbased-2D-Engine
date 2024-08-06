package physical.entity.biology;

public class Limb extends BodyComponent {
    public boolean canProsthetic = true;

    //gigantic allows 2 handed weapons to be weilded in 1 hand/manipulator
    public boolean gigantic = false;

    //Hands are attached to arms, feet to legs
    public Limb requiredLimb = null;

    public boolean isBroken = false;

    //Connectors are arms/legs, manipulators are hands/tentacles, core is the creature's chest, foot limbs contribute to speed
    enum limbType {CONNECTOR, MANIPULATOR, CORE, FOOT}

    //Stats
    public int speedBonus = 0;
    public int armor = 0;
}
