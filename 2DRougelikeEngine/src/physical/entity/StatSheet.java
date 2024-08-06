package physical.entity;

public class StatSheet {
    //where stats are stored for entities
    public int str; //strength
    public int dex; //dexterity, DV and some skills
    public int mind; /*intelligence. Creatures with less than 5 cannot speak or be attacked via mental means
    governs how well the player can Identify items, craft, and some skills
    */
    public int vit; //vitality, max hp and disease resistance
    public int arc; //arcane. Used for magic
    public int perc; //perception, used for passively identifying traps and hitting ranged/melee attacks

}
