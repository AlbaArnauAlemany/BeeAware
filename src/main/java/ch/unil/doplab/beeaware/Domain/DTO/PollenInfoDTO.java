package ch.unil.doplab.beeaware.Domain.DTO;

import ch.unil.doplab.beeaware.Domain.PollenLocationIndex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollenInfoDTO {
    private String displayName;
    private int index;
    private Date date;
    private int NPA;
    private String indexDescription;

    public PollenInfoDTO(PollenLocationIndex pollenLocationIndex) {
        this.displayName = pollenLocationIndex.getDisplayName();
        this.index = pollenLocationIndex.getIndexCharge();
        this.date = pollenLocationIndex.getDate();
        this.NPA = pollenLocationIndex.getLocation().getNPA();
        this.indexDescription = pollenLocationIndex.getIndexDescription();
    }

    @Override
    public String toString() {
        return "Name : " + displayName + ", Index : " + index + ", Date : " + date + ", NPA : " + NPA + "Index Description : " + indexDescription;
    }
}