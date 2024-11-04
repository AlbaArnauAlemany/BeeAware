package ch.unil.doplab.beeaware.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinate {
    private double latitude;
    private double longitude;
}
