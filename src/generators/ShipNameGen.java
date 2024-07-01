package generators;

import java.util.Objects;
import java.util.Random;

public class ShipNameGen {

    protected String genName;

    protected static String[] nouns = {
            "Pillar", "Seeker", "Prophet", "Soul", "Axis", "King", "Ally", "Atlas", "Yard", "Palace", "Silver", "Gold", "Bronze", "Alloy",
            "Genesis", "Scout", "Paladin", "Order", "Scribe", "Altar", "Deity", "Prince", "Star", "Nova", "Knight", "Crypt", "Stone", "Glass",
            "Dragon", "Steel", "Emporer", "Vessel", "Mind", "Treasure", "Spectacle", "Temple", "Gem", "Servant", "Raven", "Carcass", "Bones",
            "Medallion", "Haze", "Era", "Century", "Gladiator", "Republic", "Hoard", "Shadow", "Phantom", "Drake", "Giant", "Diamond",
            "Wave", "Pulse", "Screen", "Armor", "Hall", "Iron", "Wolf", "Passenger", "Chalice", "Merchant", "Wanderer", "Pendant", "Ring",
            "Demon", "Devil", "Spirit", "Predator", "Master", "Sanctuary", "Peasant", "Commander", "Arena", "Killer", "Future", "Dog",
            "Man", "Vault", "Ace", "Prisoner", "Warden", "Tomb", "Copper", "Elder", "Empire", "Past", "Obelisk", "Monument",
            "Statue", "Maniac", "Leader", "Follower", "Engineer", "Sword", "Weapon", "Saviour", "Defence", "Wall", "Compound", "Heretic",
            "Blood", "Despair", "Ghost", "Mimic", "Beggar", "God", "Coffin", "Corpse", "Skull", "Skeleton", "Bone", "Soldier", "Blight",
            "Bard", "Wound", "Gun", "Riches", "Phalanx", "Formation", "Ram", "Alien", "Angel", "Triumph", "Gravity", "Capital", "Ship",
            "Hauler", "Dust", "Paradise", "Crucible", "Rogue", "Remnants", "Lie", "Truth", "Assassin", "Abyss", "Evolution", "Ray", "Sled",
            "Destruction", "Champion", "Contender", "Ash", "Crow", "War", "Meteor", "Asteroid", "Sin", "Kingdom", "Orbiter", "Father", "Light",
            "Drop", "Dew", "Ocean", "Chasm", "Cave", "Curse", "Enclave", "Sickle", "Scythe", "Death", "Mountain", "Plan", "Pilot", "Rock",
            "Escape", "String", "Answer", "Blade", "Tale", "Fortress", "Scream", "Cry", "Paradox", "Cell", "Mystery", "Traitor",
            "Scavenger", "Tome", "Lore", "Nebula", "Ambush", "Worship", "Warship", "Wrath", "Greed", "Pride", "Envy", "Lust", "Shield", "Eclipse",
            "Gamble", "Chance", "Bomb", "Moon", "Key", "Lock", "Smith", "Head", "Calamity", "Dream", "Hope", "Draw", "Message", "Eyes", "Fate",
            "Warning", "Story", "Battle", "Battalion", "World", "Valor", "Honor", "Guard", "Vanguard", "Samurai", "Spear", "Javelin", "Bolt",
            "Mother", "Delivery", "Gift", "Hell", "Faith", "Crusader", "Study", "Hound", "Revenge", "Payment", "Hand", "Portal", "Debt",
            "Pact", "Promise", "Flower", "Surprise", "Wraith", "Interface", "Market", "Scholar", "Hunter", "Mutant", "Sea", "Brute", "Law",
            "Fire", "Cinder", "Crossing", "Line", "Duke", "Imposter", "Infiltration", "Attack", "Mistake", "Student", "Teacher", "Research",
            "Doubt", "Storm", "Cataclysm", "Catastrophe", "Present", "Phantasm", "Core", "Verdict", "Day", "Night", "Life", "Heart", "Exile",
            "Force", "Forces", "Eradicated", "River", "Flow", "Engine", "Machine", "Flux", "Love", "Enemy", "Friend", "Terror", "Generator",
            "Carrion", "Milk", "Tooth"

    };

    protected static String[] adjectives = {
            "Radiant", "Shining", "Destined", "Divine", "Screaming", "Prophisized", "Pure", "Golden", "Tarnished", "Gleaming", "Final", "Dark",
            "Last", "Precious", "Imploding", "Powerful", "Ancient", "Leaping", "Fleeing", "First", "Doomed", "Blessed", "Cursed", "Liquid",
            "Flowing", "Blind", "Mythical", "Guiding", "Stout", "Wandering", "Lost", "Apocryphal", "Stunning", "Powerful", "Guilty", "Burning",
            "Rusted", "Forsaken", "Frozen", "Derelict", "New", "Old", "Abandoned", "Deadly", "Shiny", "Dull", "Scheming", "Dead", "Living",
            "Armored", "Frail", "Elder", "Primeaval", "Lucid", "Impure", "Drunken", "Tortured", "Nascent", "Incomprehensible", "Electric",
            "Gaping", "Thinking", "Furious", "Lucky", "Unlucky", "Simple", "Complex", "Hydraulic", "Pneumatic", "Stifled", "Caged", "Weak",
            "Wealthy", "Enchanted", "Freed", "Failed", "Impenetrable", "Piercing", "Metal", "Sharp", "Destroying", "Bright", "Hopeful",
            "True", "False", "Beggining", "Ending", "Wounded", "Hidden", "Still", "Silent", "Fighting", "Toppled", "Sickened", "Reborn",
            "Thieving", "Insightful", "Healing", "Collapsed", "Inconvenient", "Alluring", "Evolved", "Scorching", "Ashen", "Deaf", "Genius",
            "Fractured", "Indestructable", "Brutal", "Forgiven", "Made in", "Dying", "Fallen", "Unstoppable", "Open", "Progenitor", "Floating",
            "Obselete", "Cut", "Limping", "Forbidden", "Legendary", "Multi", "Carrier", "Second", "Timeless", "Classic", "Painted", "Toxic",
            "Repulsive", "Stolen", "Waiting", "Cowering", "Charging", "Collapsing", "Evil", "Hardened", "Rabid", "Double", "Long", "Berserk",
            "Barren", "Brazen", "Hated", "Hollow", "Branded", "Whole", "Holy", "Unholy", "Bought", "Sold", "Captured", "Deep", "Sleeping",
            "Shallow", "Honest", "Young", "Drowning", "Bizarre", "Heroic", "Forced", "Voluntary", "Violent", "Peaceful", "Weeping"
    };

    public String getNoun() {
        // Generate a random positive adjective
        Random rand = new Random();
        return nouns[rand.nextInt(nouns.length)];
    }

    public String getAdj() {
        // Generate a random positive adjective
        Random rand = new Random();
        return adjectives[rand.nextInt(adjectives.length)];
    }

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public String newName() {
        Random rand = new Random();
        String message;
        String word1 = "null";
        String word2 = "null";

        if(rand.nextInt(100) >= 70)
        {
            while(Objects.equals(word1, word2))
            {
                word1 = getNoun();
                word2 = getNoun();
            }

            if(word1.charAt(word1.length() - 1) == 's'){
                word1 = word1.substring(0, word1.length() - 1);
                word1 += "'s";
                message = word1 + " " + word2;
            }else{
                message = word1 + "'s " + word2;
            }
        }else{
            while(Objects.equals(word1, word2))
            {
                word1 = getAdj();
                word2 = getNoun();
            }
            message = word1 + " " + word2;
        }
        return message;
    }

    public static void main(String[] args)
    {
        ShipNameGen testGen = new ShipNameGen();
        while(true){
            System.out.println(testGen.newName());
        }
    }

}

