package physical.entity;

public class Disease {
    public String name;
    //turns before symptoms appear
    public int dormantTurns = 0;
    //turns before disease is fought off. Chronic diseases last forever.
    public int remainingTurns;
    public boolean fullBody = false;
    public boolean fungal = false;
    //can be transmitted across species
    public boolean crossSpecies = true;
    //is it a mechanical/artificial disease
    public boolean artificial = false;
    //how easily can it spread by %? higher num = more infectious
    public int spreadChance = 1;
    //if an illness can spread to other BodyComponents
    public int bodySpreadChance = 1;

    @Override
    public String toString() {
        return name;
    }
}
