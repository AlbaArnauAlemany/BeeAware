package ch.unil.doplab.beeaware.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.maps.errors.ApiException;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.*;

/**
 * Represents a user (Beezzer) in the system, containing personal information
 * such as username, email, password, location, and allergens.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Beezzer {
    private Long id;                // Unique identifier for the Beezzer
    private String username;        // Unique username of the Beezzer
    private String email;           // Email address of the Beezzer
    private String password;        // Password of the Beezzer, hashed for security
    private Location location;      // Location of the Beezzer composed of NPA & Country
    private Map<Long, Pollen> allergens;  // Set of pollen allergens for the Beezzer

    private Role role;
    /**
     * Constructs a new Beezzer object with the specified username, email,
     * password, NPA, and country.
     * The id parameter is set to null, allowing for simpler instantiation
     * without providing an identifier.
     *
     * @param username The username for the Beezzer.
     * @param email The email address for the Beezzer.
     * @param password The password for the Beezzer, which will be hashed.
     * @param role The role of the user, it can be ADMIN or BEEZZER for lambda users.
     */
    public Beezzer(String username, String email, String password, Location location, Role role) {
        // this() calls the primary constructor (the one with the id
        // parameter) by passing null as the id argument
        this(null, username, email, password, location, role);
    }

    /**
     * Constructs a new Beezzer object with the specified id, username, email,
     * password, NPA, and country. The password is hashed for security, and the
     * location is initialized based on the provided NPA and country. This
     * constructor also initializes the allergens set and adds the Beezzer
     * instance to some collection.
     *
     * @param id The unique identifier for the Beezzer (can be null for new instances).
     * @param username The username for the Beezzer.
     * @param email The email address for the Beezzer.
     * @param password The password for the Beezzer, which will be hashed.
     * @param role The role of the user, it can be ADMIN or BEEZZER for lambda users.
     */
    public Beezzer(Long id, String username, String email, String password, Location location, Role role) {
        this.id = id; // Assign the id to the Beezzer
        this.username = username; // Assign the username to the Beezzer (username must not be bull)
        this.email = email; // Assign the email to the Beezzer
        this.password = PasswordUtilis.hashPassword(password); // Hash the password
        this.location = location; // Create a new Location instance
        this.allergens = new HashMap<>(); // Initialize the allergens set
        this.role = role;
    }

    /**
     * Returns a string representation of the Beezzer object.
     * This method builds a string that includes the Beezzer's username, email,
     * and a list of allergens. It also prints the location details such as
     * ID, NPA, country, latitude, and longitude to the console. (The string
     * representation is useful for logging and debugging purposes.)
     *
     * @return A string containing the username, email, and a space-separated
     *         list of allergens. In addition, location details are displayed.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Username: ").append(username).append("\n")
                .append("Email: ").append(email).append("\n")
                .append("Role : ").append(role).append("\n")
                .append("Allergens: ");
        for (Map.Entry<Long, Pollen> allergen : allergens.entrySet()) {
            result.append(allergen.getValue().getPollenNameEN()).append(" ");
        }
        System.out.println("ID: " + location.getId());
        System.out.println("NPA: " + location.getNPA());
        System.out.println("Country:" + location.getCountry());
        System.out.println("Latitude: " + location.getCoordinate().getLatitude());
        System.out.println("Longitude: " + location.getCoordinate().getLongitude());
        return result.toString().trim();
    }
}
