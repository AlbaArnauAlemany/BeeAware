package ch.unil.doplab.beeaware.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.maps.errors.ApiException;
import jakarta.persistence.*;
import lombok.*;
import org.intellij.lang.annotations.Identifier;
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
@Entity
public class Beezzer {

    @Id
    @Column(name= "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // Unique identifier for the Beezzer

    @Column(name = "USERNAME")
    private String username;        // Unique username of the Beezzer

    @Column(name = "EMAIL")
    private String email;           // Email address of the Beezzer

    @Column(name = "PASSWORD")
    private String password;        // Password of the Beezzer, hashed for security

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LOCATION")
    private Location location;      // Location of the Beezzer composed of NPA & Country

    @ManyToMany
    @JoinTable(
            name = "allergens",
            joinColumns = @JoinColumn(name = "beezzer_id"),
            inverseJoinColumns = @JoinColumn(name = "pollen_id")
    )
    private List<Pollen> allergens;  // Set of pollen allergens for the Beezzer

    @Column(name = "ROLE")
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

    public Beezzer(String username, String email) {
        // this() calls the primary constructor (the one with the id
        // parameter) by passing null as the id argument
        this.username = username;
        this.email = email;
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

        if (id != null) {
            this.id = id; // Assign the id to the Beezzer
        }
        if (username != null) {
            this.username = username; // Assign the username to the Beezzer (username must not be bull)
        }
        if (email != null) {
            this.email = email; // Assign the email to the Beezzer
        }

        if (password != null) {
            this.password = password;
        }
        if (location != null) {
            this.location = location; // Create a new Location instance
        }

        this.allergens = new ArrayList<>(); // Initialize the allergens set

        if (role != null) {
            this.role = role;
        }
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
        if (username != null) {
            result.append("Username: ").append(username).append("\n");
        }
        if (email != null) {
            result.append("Email: ").append(email).append("\n");
        }
        if (role != null) {
            result.append("Role : ").append(role).append("\n");
        }
        if (allergens != null) {
            result.append("Allergens: ");
            for (Pollen allergen : allergens) {
                result.append(allergen.getPollenNameEN()).append(" ");
            }
        }
        if (location != null) {
            result.append("ID: " + location.getId());
            result.append("NPA: " + location.getNPA());
            result.append("City Name" + location.getCityName());
            result.append("Country:" + location.getCountry());
            if (location.getCoordinate() != null) {
                result.append("Latitude: " + location.getCoordinate().getLatitude());
                result.append("Longitude: " + location.getCoordinate().getLongitude());
            }
        }
        return result.toString().trim();
    }
}
