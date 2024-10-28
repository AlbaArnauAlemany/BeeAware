package ch.unil.doplab.beeaware.Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Pollen {
    private Long id;
    private final String pollenNameEN;

    private static final Map<String, Pollen> predefinedPollens = new HashMap<>();

    // API Swiss pollens: hazel, alder, ash, birch, cottonwood, oak, olive, pine, grasses, ragweed, mugwort
    // in french: noisette, aulne, frêne, bouleau, peuplier, chêne, olive, pin, herbes, herbe à poudre, armoise
    static {
        predefinedPollens.put("HAZEL", new Pollen(0L, "Hazel"));
        predefinedPollens.put("ALDER", new Pollen(1L, "Alder"));
        predefinedPollens.put("ASH", new Pollen(2L, "Ash"));
        predefinedPollens.put("BIRCH", new Pollen(3L, "Birch"));
        predefinedPollens.put("COTTONWOOD", new Pollen(4L, "Cottonwood"));
        predefinedPollens.put("OAK", new Pollen(5L, "Oak"));
        predefinedPollens.put("OLIVE", new Pollen(6L, "Olive"));
        predefinedPollens.put("PINE", new Pollen(7L, "Pine"));
        predefinedPollens.put("GRASSES", new Pollen(8L, "Grasses"));
        predefinedPollens.put("RAGWEED", new Pollen(9L, "Ragweed"));
        predefinedPollens.put("MUGWORT", new Pollen(10L, "Mugwort"));
        predefinedPollens.put("WEED", new Pollen(11L, "Weed"));
    }

    private Pollen(Long id, String pollenNameEN) {
        this.id = id;
        this.pollenNameEN = pollenNameEN;
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
