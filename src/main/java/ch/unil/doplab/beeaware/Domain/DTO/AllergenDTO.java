package ch.unil.doplab.beeaware.Domain.DTO;

import ch.unil.doplab.beeaware.Domain.Pollen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class AllergenDTO {
    List<PollenDTO> pollenList = new ArrayList<>();

    public AllergenDTO(List<Pollen> allergens) {
        for (Pollen pollen : allergens) {
            PollenDTO pollenDTO = new PollenDTO(pollen);
            pollenList.add(pollenDTO);
        }
    }
}
