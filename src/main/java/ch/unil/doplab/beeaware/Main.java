//package ch.unil.doplab.beeaware;
//
//import ch.unil.doplab.beeaware.Domain.Beezzer;
//import ch.unil.doplab.beeaware.Domain.DTO.PollenInfoDTO;
//import ch.unil.doplab.beeaware.Domain.Pollen;
//import ch.unil.doplab.beeaware.Domain.Symptom;
//import com.google.maps.errors.ApiException;
//
//import java.io.IOException;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.util.List;
//
//import static ch.unil.doplab.beeaware.Utilis.*;
//
//
//public class Main {
//
//    public static void main(String[] args) {
//        Beezzer alba = null;
//        try {
//            alba = new Beezzer("alba", "alba.arnau.alemany@gmail.com", "Q.-wDw123", 1024, "CH");
//        } catch (ApiException | InterruptedException | IOException e) {
//            e.printStackTrace();
//        }
//        alba.addAllergen(Pollen.getPollenByName("Grasses"));
//        alba.addAllergen(Pollen.getPollenByName("Weed"));
//
//        Symptom symptom1 = new Symptom(alba.getId(), 8, false);
//        Symptom symptom2 = new Symptom(alba.getId(), 5, false);
//        Symptom symptom3 = new Symptom(alba.getId(), 3, true);
//        addSymptom(symptom1, alba);
//        addSymptom(symptom2, alba);
//        addSymptomForASpecificDate(symptom3, alba, new GregorianCalendar(2024, Calendar.FEBRUARY, 11).getTime());
//        System.out.println(alba);
//        for (Symptom symptom:getSymptomsForASpecificBeezzer(alba)) {
//            System.out.println(symptom);
//        };
//
//        forecastAllLocation();
//
//        List<PollenInfoDTO> PollenShortDTOs = getIndexForSpecificBeezzer(alba);
//        for (PollenInfoDTO pollen : PollenShortDTOs) {
//            System.out.println(pollen);
//        }
//    }
//}
//
