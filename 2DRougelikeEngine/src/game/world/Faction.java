package game.world;

import game.Description;

import java.util.ArrayList;

public class Faction {
    public String name;

    public Description description;

    //if a faction is not contained in this list, neutral to the faction
    public ArrayList<Faction> friendly;
    public ArrayList<Faction> hostile;
}
