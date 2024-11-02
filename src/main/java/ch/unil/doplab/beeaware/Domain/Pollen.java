package ch.unil.doplab.beeaware.Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * The {@code Pollen} class represents a type of pollen with a unique ID and a name.
 * It also maintains a predefined list of pollens and provides functionality
 * to retrieve them based on country-specific data.
 */

@Getter
@Setter
public class Pollen {
    private Long id; // The unique identifier for the pollen type
    private final String pollenNameEN; // The english name of the pollen

    // A map of predefined pollen types
    private static final Map<String, Pollen> predefinedPollens = new HashMap<>();

    // Static initializer for predefined pollens
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

    /**
     * Constructs a new {@code Pollen} instance with the specified id and name.
     *
     * @param id The unique identifier for this pollen
     * @param pollenNameEN The name of the pollen in English
     */
    private Pollen(Long id, String pollenNameEN) {
        this.id = id;
        this.pollenNameEN = pollenNameEN;
    }

    /**
     * Retrieves all predefined pollen types.
     *
     * @return An unmodifiable set of predefined {@code Pollen} objects
     */
    public static Set<Pollen> getPredefinedPollens() {
        return Collections.unmodifiableSet(new HashSet<>(predefinedPollens.values()));
    }

    /**
     * Retrieves a predefined pollen by its name.
     *
     * @param pollenNameEN The name of the pollen in English
     * @return The {@code Pollen} object corresponding to the specified name
     * @throws IllegalArgumentException if the pollen name is null or not predefined
     */
    public static Pollen getPollenByName(String pollenNameEN) {
        if (pollenNameEN == null || !predefinedPollens.containsKey(pollenNameEN.toUpperCase())) {
            throw new IllegalArgumentException("This pollen is not predefined: " + pollenNameEN);
        }
        return predefinedPollens.get(pollenNameEN.toUpperCase());
    }
}
