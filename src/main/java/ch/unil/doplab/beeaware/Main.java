package ch.unil.doplab.beeaware;

import ch.unil.doplab.beeaware.Domain.Beezzer;
import ch.unil.doplab.beeaware.Domain.Pollen;
import com.google.maps.errors.ApiException;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        Beezzer alba = null;
        try {
            alba = new Beezzer("alba", "alba.arnau.alemany@gmail.com", "Q.-wDw123");
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        alba.addAllergen(Pollen.getPollenByName("oak"));
        alba.addAllergen(Pollen.getPollenByName("PINE"));
        System.out.println(alba);
    }
}
