package ch.unil.doplab.beeaware.Domain;

import java.util.Map;

public class Allergen {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Location location;
    private String antihistamine;
    private Map<Long, Pollen> allergens;
}
