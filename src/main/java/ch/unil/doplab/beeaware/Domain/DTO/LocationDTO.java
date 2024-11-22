package ch.unil.doplab.beeaware.Domain.DTO;

import ch.unil.doplab.beeaware.Domain.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {
    private String country;
    private int NPA;
    private String cityName;

    public LocationDTO(Location location) {
        this.NPA = location.getNPA();
        this.cityName = location.getCityName();
        this.country = location.getCountry();
    }
}
