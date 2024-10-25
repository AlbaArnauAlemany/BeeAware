package ch.unil.doplab.beeaware.domain;

import java.util.HashSet;
import java.util.Set;

public class Pollen {

    private final String pollenID;
    private final String pollenNameEN;
    private final String pollenNameFR;

    public Pollen(String pollenID, String pollenNameEN, String pollenNameFR) {
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

    // API Swiss pollens: hazel, alder, ash, birch, cottonwood, oak, olive, pine, grasses, ragweed, mugwort
    // in french: noisette, aulne, frêne, bouleau, peuplier, chêne, olive, pin, herbes, herbe à poudre, armoise
    public static final Pollen HAZEL = new Pollen("Pollen2","hazel", "noisette");
    public static final Pollen ALDER = new Pollen("Pollen2", "alder", "aulne");
    public static final Pollen ASH = new Pollen("Pollen3", "ash", "frêne");
    public static final Pollen BIRCH = new Pollen("Pollen4", "birch", "bouleau");
    public static final Pollen COTTONWOOD = new Pollen("Pollen5", "cottonwood", "peuplier");
    public static final Pollen OAK = new Pollen("Pollen6", "oak", "chêne");
    public static final Pollen OLIVE = new Pollen("Pollen7", "olive", "olive");
    public static final Pollen PINE = new Pollen("Pollen8", "pine", "pin");
    public static final Pollen GRASSES = new Pollen("Pollen9", "grasses", "herbes");
    public static final Pollen RAGWEED = new Pollen("Pollen10", "ragweed", "herbe à poudre");
    public static final Pollen MUGWORT = new Pollen("Pollen11", "mugwort", "armoise");

    public static Set<Pollen> getPredefinedPollens() {
        Set<Pollen> predefinedPollens = new HashSet<>();
        predefinedPollens.add(HAZEL);
        predefinedPollens.add(ALDER);
        predefinedPollens.add(ASH);
        predefinedPollens.add(BIRCH);
        predefinedPollens.add(COTTONWOOD);
        predefinedPollens.add(OAK);
        predefinedPollens.add(OLIVE);
        predefinedPollens.add(PINE);
        predefinedPollens.add(GRASSES);
        predefinedPollens.add(RAGWEED);
        predefinedPollens.add(MUGWORT);
        return predefinedPollens;
    }

}
