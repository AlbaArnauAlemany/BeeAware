//package ch.unil.doplab.beeaware;
//
//import ch.unil.doplab.beeaware.Domain.*;
//import ch.unil.doplab.beeaware.Domain.DTO.PollenInfoDTO;
//
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.*;
//
//import static ch.unil.doplab.beeaware.Domain.PollenLocationIndex.pollenForecast;
//
//public class Utilis {
//    public static final List<PollenLocationIndex> PollenLocationIndexArray = new ArrayList<>();
//    public static Set<Location> Locations = new HashSet<>();
//    public static Set<Beezzer> Beezzers = new HashSet<>();
//    public static List<Symptom> Symptoms = new ArrayList<>();
//
//
//
//    public static Long idBeezzer = 0L;
//    public static Long idLocation = 0L;
//    public static Long idPollenIndex = 0L;
//    public static Long idSymptom = 0L;
//
//
//    public static void addBeezzer(Beezzer beezzer){
//        for (Beezzer bee: Beezzers) {
//            if (beezzer.getUsername() != null && bee.getUsername() != null && beezzer.getUsername() == bee.getUsername()) {
//                throw new IllegalArgumentException("Username " + beezzer.getUsername() + " already used. Please try a new one.");
//            }
//        }
//        beezzer.setId(idBeezzer++);
//        Beezzers.add(beezzer);
//    }
//
//    public static void addSymptomForASpecificDate(Symptom symptom, Beezzer beezzer, Date date){
//        symptom.setDate(date);
//        for (Symptom sym: Symptoms) {
//            if (beezzer.getId() == sym.getUserId() && isSameDay(sym.getDate(), date)) {
//                symptom.setId(sym.getId());
//                Symptoms.set(Symptoms.indexOf(sym), symptom);
//                return;
//            }
//        }
//        symptom.setId(idSymptom++);
//        Symptoms.add(symptom);
//    }
//
//    public static void addSymptom(Symptom symptom, Beezzer beezzer){
//        Date todayDate = new Date();
//        symptom.setDate(todayDate);
//        for (Symptom sym: Symptoms) {
//            if (beezzer.getId() == sym.getUserId() && isSameDay(sym.getDate(), todayDate)) {
//                symptom.setId(sym.getId());
//                Symptoms.set(Symptoms.indexOf(sym), symptom);
//                return;
//            }
//        }
//        symptom.setId(idSymptom++);
//        Symptoms.add(symptom);
//    }
//
//    public static List<Symptom> getSymptomsForASpecificBeezzer(Beezzer beezzer){
//        List<Symptom> symptoms = new ArrayList<>();
//        for (Symptom sym: Symptoms) {
//            if (beezzer.getId() == sym.getUserId()) {
//                symptoms.add(sym);
//            }
//        }
//        return symptoms;
//    }
//
//    public static List<Symptom>  getSymptomsForASpecificDate(Beezzer beezzer, Date date){
//        List<Symptom> symptoms = new ArrayList<>();
//        for (Symptom sym: Symptoms) {
//            if (beezzer.getId() == sym.getUserId()) {
//                if (beezzer.getId() == sym.getUserId() && isSameDay(sym.getDate(), date)) {
//                    symptoms.add(sym);
//                }
//            }
//        }
//        return symptoms;
//    }
//
//    public static void addPollenIndexLocation(PollenLocationIndex pollenLocationIndex) {
//        for (PollenLocationIndex pil: PollenLocationIndexArray) {
//            if (pil.getLocation() != null && pil.getLocation().getNPA() == pollenLocationIndex.getLocation().getNPA()) {
//                return;
//            }
//        }
//        pollenLocationIndex.setId(idPollenIndex++);
//        PollenLocationIndexArray.add(pollenLocationIndex);
//    }
//
//    public static void addLocation(Location location) {
//        for (Location loc: Locations) {
//            if (location != null && loc.getNPA() == location.getNPA()) {
//                return;
//            }
//        }
//        location.setId(idLocation++);;
//        Locations.add(location);
//    }
//
//    public static void forecastAllLocation(){
//        for (Location location : Locations) {
//            pollenForecast(location, 1);
//        }
//    }
//
//    public static List<PollenInfoDTO> getIndexForSpecificBeezzer(Beezzer beezzer){
//        List<PollenInfoDTO> PollenShortDTOs = new ArrayList<>();
//        for (PollenLocationIndex pollenLocationIndex : PollenLocationIndexArray) {
//            if(pollenLocationIndex.getLocation().getNPA() == beezzer.getLocation().getNPA()){
//
//                for (PollenLocationIndex.DailyInfo dailyInfo : pollenLocationIndex.getDailyInfo()) {
//
//                    for (PollenLocationIndex.PollenTypeInfo pollenTypeDailyInfo : dailyInfo.getPollenTypeInfo()) {
//                        for (Pollen pollen : beezzer.getAllergens()) {
//                            if (pollen.getPollenNameEN().equals(pollenTypeDailyInfo.getDisplayName())) {
//                                if (pollenTypeDailyInfo.getIndexInfo() != null) {
//                                    PollenShortDTOs.add(new PollenInfoDTO(pollenTypeDailyInfo.getDisplayName(), pollenTypeDailyInfo.getIndexInfo().getValue(), pollenTypeDailyInfo.getIndexInfo().getIndexDescription(), ""));
//                                }
//                            }
//                        }
//                    }
//
//                    for (PollenLocationIndex.PlantInfo pollenDailyInfo : dailyInfo.getPlantInfo()) {
//                        for (Pollen pollen : beezzer.getAllergens()) {
//                            if (pollen.getPollenNameEN().equals(pollenDailyInfo.getDisplayName())) {
//                                if (pollenDailyInfo.getIndexInfo() != null) {
//                                    PollenShortDTOs.add(new PollenInfoDTO(pollenDailyInfo.getDisplayName(), pollenDailyInfo.getIndexInfo().getValue(), pollenDailyInfo.getIndexInfo().getIndexDescription(), pollenDailyInfo.getPlantDescription().getCrossReaction()));
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return PollenShortDTOs;
//    }
//
//    public static boolean isSameDay(Date date1, Date date2) {
//        LocalDate localDate1 = date1.toInstant()
//                .atZone(ZoneId.systemDefault())
//                .toLocalDate();
//        LocalDate localDate2 = date2.toInstant()
//                .atZone(ZoneId.systemDefault())
//                .toLocalDate();
//        return localDate1.isEqual(localDate2);
//    }
//}
