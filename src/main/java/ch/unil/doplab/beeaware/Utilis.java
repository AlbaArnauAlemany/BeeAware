package ch.unil.doplab.beeaware;

import ch.unil.doplab.beeaware.Domain.Beezzer;
import ch.unil.doplab.beeaware.Domain.DTO.PollenInfoDTO;
import ch.unil.doplab.beeaware.Domain.Location;
import ch.unil.doplab.beeaware.Domain.Pollen;
import ch.unil.doplab.beeaware.Domain.PollenLocationIndex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ch.unil.doplab.beeaware.Domain.PollenLocationIndex.pollenForecast;

public class Utilis {
    public static final List<PollenLocationIndex> PollenLocationIndexArray = new ArrayList<>();
    public static Set<Location> Locations = new HashSet<>();
    public static Set<Beezzer> Beezzers = new HashSet<>();



    public static Long idBeezzer = 0L;
    public static Long idLocation = 0L;
    public static Long idPollenIndex = 0L;


    public static void addBeezzer(Beezzer beezzer){
        for (Beezzer bee: Beezzers) {
            if (beezzer.getUsername() != null && bee.getUsername() != null && beezzer.getUsername() == bee.getUsername()) {
                throw new IllegalArgumentException("Username " + beezzer.getUsername() + " already used. Please try a new one.");
            }
        }
        beezzer.setId(idBeezzer++);
        Beezzers.add(beezzer);
    }

    public static void addPollenIndexLocation(PollenLocationIndex pollenLocationIndex) {
        for (PollenLocationIndex pil: PollenLocationIndexArray) {
            if (pil.getLocation() != null && pil.getLocation().getNPA() == pollenLocationIndex.getLocation().getNPA()) {
                return;
            }
        }
        pollenLocationIndex.setId(idPollenIndex++);
        PollenLocationIndexArray.add(pollenLocationIndex);
    }

    public static void addLocation(Location location) {
        for (Location loc: Locations) {
            if (location != null && loc.getNPA() == location.getNPA()) {
                return;
            }
        }
        location.setId(idLocation++);;
        Locations.add(location);
    }

    public static void forecastAllLocation(){
        for (Location location : Locations) {
            pollenForecast(location, 1);
        }
    }

    public static List<PollenInfoDTO> getIndexForSpecificBeezer(Beezzer beezzer){
        List<PollenInfoDTO> PollenShortDTOs = new ArrayList<>();
        for (PollenLocationIndex pollenLocationIndex : PollenLocationIndexArray) {
            if(pollenLocationIndex.getLocation().getNPA() == beezzer.getLocation().getNPA()){

                for (PollenLocationIndex.DailyInfo dailyInfo : pollenLocationIndex.getDailyInfo()) {

                    for (PollenLocationIndex.PollenTypeInfo pollenTypeDailyInfo : dailyInfo.getPollenTypeInfo()) {
                        for (Pollen pollen : beezzer.getAllergens()) {
                            if (pollen.getPollenNameEN().equals(pollenTypeDailyInfo.getDisplayName())) {
                                if (pollenTypeDailyInfo.getIndexInfo() != null) {
                                    PollenShortDTOs.add(new PollenInfoDTO(pollenTypeDailyInfo.getDisplayName(), pollenTypeDailyInfo.getIndexInfo().getValue(), pollenTypeDailyInfo.getIndexInfo().getIndexDescription()));
                                }
                            }
                        }
                    }

                    for (PollenLocationIndex.PlantInfo pollenDailyInfo : dailyInfo.getPlantInfo()) {
                        for (Pollen pollen : beezzer.getAllergens()) {
                            if (pollen.getPollenNameEN().equals(pollenDailyInfo.getDisplayName())) {
                                if (pollenDailyInfo.getIndexInfo() != null) {
                                    PollenShortDTOs.add(new PollenInfoDTO(pollenDailyInfo.getDisplayName(), pollenDailyInfo.getIndexInfo().getValue(), pollenDailyInfo.getIndexInfo().getIndexDescription()));
                                }
                            }
                        }
                    }
                }
            }
        }
        return PollenShortDTOs;
    }
}
