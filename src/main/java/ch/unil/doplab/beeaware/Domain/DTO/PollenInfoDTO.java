package ch.unil.doplab.beeaware.Domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollenInfoDTO {
    private String displayName;
    private int index;
    private String Recommendation;

    @Override
    public String toString() {
        return "Name : " + displayName + ", Index : " + index + "\n" + "Recommandation : " + Recommendation;
    }
}
