package ch.unil.doplab.beeaware.Domain;

import com.google.maps.errors.ApiException;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Beezzer {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Location locationID;
    private String antihistamine;
    private Set<Pollen> allergens;

    private static Set<Beezzer> Beezzers = new HashSet<>();
    private static Long idBeezzer = 0L;

    public Beezzer(String username, String email, String password) throws IOException, InterruptedException, ApiException {
        this(null, username, email, password);
    }

    public Beezzer(Long id, String username, String email, String password) throws IOException, InterruptedException, ApiException {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = PasswordUtilis.hashPassword(password);
        this.locationID = new Location();
        this.allergens = new HashSet<>();
        addBeezzer(this);
    }

    public void addBeezzer(Beezzer beezzer){
        for (Beezzer bee: Beezzers) {
            if (beezzer.getUsername() != null && bee.username != null && beezzer.getUsername() == bee.username) {
                throw new IllegalArgumentException("Username " + username + " already used. Please try a new one.");
            }
        }
        Beezzers.add(beezzer);
    }

    public void addAllergen(Pollen pollen) {
        if (pollen != null && Pollen.getPredefinedPollens().contains(pollen)) {
            allergens.add(pollen);
        } else {
            throw new IllegalArgumentException("This pollen is not available in your country.");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Username: ").append(username).append("\n")
                .append("Email: ").append(email).append("\n")
                .append("Allergens: ");
        for (Pollen allergen : allergens) {
            result.append(allergen.getPollenNameEN()).append(" ");
        }
        System.out.println("ID:" + locationID.getId());
        System.out.println("Latitude: " + locationID.getLatitude());
        System.out.println("Longitude: " + locationID.getLongitude());
        return result.toString().trim();
    }
}