package ch.unil.doplab.beeaware.domain;

import java.util.*;

public class Pollen {
    private final String pollenID;
    private final String pollenNameEN;
    private final String pollenNameFR;

    private static final Map<String, Pollen> predefinedPollens = new HashMap<>();

    // API Swiss pollens: hazel, alder, ash, birch, cottonwood, oak, olive, pine, grasses, ragweed, mugwort
    // in french: noisette, aulne, frêne, bouleau, peuplier, chêne, olive, pin, herbes, herbe à poudre, armoise
    static {
        predefinedPollens.put("HAZEL", new Pollen("Pollen2", "hazel", "noisette"));
        predefinedPollens.put("ALDER", new Pollen("Pollen2", "alder", "aulne"));
        predefinedPollens.put("ASH", new Pollen("Pollen3", "ash", "frêne"));
        predefinedPollens.put("BIRCH", new Pollen("Pollen4", "birch", "bouleau"));
        predefinedPollens.put("COTTONWOOD", new Pollen("Pollen5", "cottonwood", "peuplier"));
        predefinedPollens.put("OAK", new Pollen("Pollen6", "oak", "chêne"));
        predefinedPollens.put("OLIVE", new Pollen("Pollen7", "olive", "olive"));
        predefinedPollens.put("PINE", new Pollen("Pollen8", "pine", "pin"));
        predefinedPollens.put("GRASSES", new Pollen("Pollen9", "grasses", "herbes"));
        predefinedPollens.put("RAGWEED", new Pollen("Pollen10", "ragweed", "herbe à poudre"));
        predefinedPollens.put("MUGWORT", new Pollen("Pollen11", "mugwort", "armoise"));
    }

    private Pollen(String pollenID, String pollenNameEN, String pollenNameFR) {
        this.pollenID = pollenID;
        this.pollenNameEN = pollenNameEN;
        this.pollenNameFR = pollenNameFR;
    }

    public String getPollenID() {
        return pollenID;
    }

    public String getPollenNameEN() {
        return pollenNameEN;
    }

    public String getPollenNameFR() {
        return pollenNameFR;
    }

    public static Set<Pollen> getPredefinedPollens() {
        return Collections.unmodifiableSet(new HashSet<>(predefinedPollens.values()));
    }

    public static Pollen getPollenByName(String pollenNameEN) {
        if (pollenNameEN == null || !predefinedPollens.containsKey(pollenNameEN.toUpperCase())) {
            throw new IllegalArgumentException("This pollen is not predefined: " + pollenNameEN);
        }
        return predefinedPollens.get(pollenNameEN.toUpperCase());
    }

}
