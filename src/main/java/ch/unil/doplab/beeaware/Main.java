package ch.unil.doplab.beeaware;

import ch.unil.doplab.beeaware.Domain.Beezzer;
import ch.unil.doplab.beeaware.Domain.DTO.PollenInfoDTO;
import ch.unil.doplab.beeaware.Domain.Pollen;
import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.util.List;

import static ch.unil.doplab.beeaware.Utilis.forecastAllLocation;
import static ch.unil.doplab.beeaware.Utilis.getIndexForSpecificBeezer;


public class Main {

    public static void main(String[] args) {
        Beezzer alba = null;
        try {
            alba = new Beezzer("alba", "alba.arnau.alemany@gmail.com", "Q.-wDw123", 1024, "CH");
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        alba.addAllergen(Pollen.getPollenByName("Grasses"));
        alba.addAllergen(Pollen.getPollenByName("Weed"));
        System.out.println(alba);

        forecastAllLocation();

        List<PollenInfoDTO> PollenShortDTOs = getIndexForSpecificBeezer(alba);
        for (PollenInfoDTO pollen : PollenShortDTOs) {
            System.out.println(pollen);
        }
    }
}
