package ch.unil.doplab.beeaware.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Allergen {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Location location;
    private String antihistamine;
    private Map<Long, Pollen> allergens;
}
