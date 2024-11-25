package ch.unil.doplab.beeaware.Domain.DTO;

import ch.unil.doplab.beeaware.Domain.Coordinate;
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
    private Coordinate coordinate;

    public LocationDTO(Location location) {
        this.NPA = location.getNPA();
        this.country = location.getCountry();
        this.cityName = location.getCityName();
        if(location.getCoordinate() != null){
            this.coordinate = location.getCoordinate();
        }
    }
}