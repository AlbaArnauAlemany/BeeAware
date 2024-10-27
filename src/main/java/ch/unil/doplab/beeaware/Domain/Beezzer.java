package ch.unil.doplab.beeaware.Domain;

import com.google.maps.errors.ApiException;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static ch.unil.doplab.beeaware.Utilis.addBeezzer;

@Getter
@Setter
public class Beezzer {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Location location;
    private String antihistamine;
    private Set<Pollen> allergens;

    public Beezzer(String username, String email, String password, int NPA, String country) throws IOException, InterruptedException, ApiException {
        this(null, username, email, password, NPA, country);
    }

    public Beezzer(Long id, String username, String email, String password, int NPA, String country) throws IOException, InterruptedException, ApiException {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = PasswordUtilis.hashPassword(password);
        this.location = new Location(NPA, country);
        this.allergens = new HashSet<>();
        addBeezzer(this);
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
        System.out.println("ID: " + location.getId());
        System.out.println("NPA: " + location.getNPA());
        System.out.println("Country:" + location.getCountry());
        System.out.println("Latitude: " + location.getLatitude());
        System.out.println("Longitude: " + location.getLongitude());
        return result.toString().trim();
    }
}