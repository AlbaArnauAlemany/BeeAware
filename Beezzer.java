package ch.unil.doplab.beeaware.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static ch.unil.doplab.beeaware.domain.PasswordHasher.hashPassword;

public class Beezzer {
    private static Set<String> usernames = new HashSet<>();

    private UUID uuid;
    private String username;
    private String email;
    private String password;
    private Location locationID;
    private Boolean antihistamine;
    private Set<Pollen> allergens;

    public Beezzer() {
        this(null, null, null, null);
    }

    public Beezzer(String username, String email, String password) {
        this(null, username, email, password);
    }

    public Beezzer(UUID uuid, String username, String email, String password) {
        if (username != null && usernames.contains(username)) {
            throw new IllegalArgumentException("Username already used. Please try a new one.");
        }
        this.uuid = uuid;
        this.username = username;
        if (username != null) {
            usernames.add(username);
        }
        this.email = email;
        this.password = hashPassword(password);
        this.locationID = new Location();
        this.antihistamine = false;
        this.allergens = new HashSet<>();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public Location getLocationID() {
        return locationID;
    }

    public Boolean getAntihistamine() {
        return antihistamine;
    }

    public Set<Pollen> getAllergens() {
        return allergens;
    }

    public void addAllergen(Pollen pollen) {
        if (Pollen.getPredefinedPollens().contains(pollen)) {
            allergens.add(pollen);
        } else {
            throw new IllegalArgumentException("This pollen is not available in your country.");
        }
    }
}