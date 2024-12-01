package ch.unil.doplab.beeaware.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * Represents an index of pollen charge and related information in a particular location
 * and date, constructed based on the PollenLocationInfo class.
 * This class includes details such as the pollen name, pollen charge, date,
 * location, health recommendations, and potential cross-reactions.
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PollenLocationIndex {
    private Long id;
    private String displayName;
    private int index;
    private Date date;
    private Location location;
    private List<String> recommendation;
    private String crossReaction;
    private String indexDescription;

    /**
     * Constructs a PollenLocationIndex object with specified parameters.
     *
     * @param displayName The name of the pollen.
     * @param index The pollen charge level.
     * @param date The date for the pollen index.
     * @param location The location associated with the pollen index.
     * @param recommendation A list of health recommendations related to the pollen index.
     * @param crossReaction Information about potential cross-reactions with other allergens.
     * @param indexDescription Information about the index.
     */
    public PollenLocationIndex(String displayName, int index, Date date, Location location, List<String> recommendation, String crossReaction, String indexDescription){
        this.displayName = displayName;
        this.index = index;
        this.date = date;
        this.location = location;
        this.recommendation = recommendation == null ? new ArrayList<>() : recommendation;
        this.crossReaction = crossReaction == null ? "No crossReaction" : crossReaction;
        this.indexDescription = indexDescription == null ? "No description" : indexDescription;
    }

    public PollenLocationIndex(PollenLocationInfo.PollenTypeInfo pollenTypeDailyInfo, Date date, Location location) {
        this(pollenTypeDailyInfo.getDisplayName(), pollenTypeDailyInfo.getIndexInfo().getValue(), date, location, pollenTypeDailyInfo.getHealthRecommendations(), "", pollenTypeDailyInfo.getIndexInfo().getIndexDescription());
    }

    public PollenLocationIndex(PollenLocationInfo.PlantInfo pollenDailyInfo, Date date, Location location) {
        this(pollenDailyInfo.getDisplayName(), pollenDailyInfo.getIndexInfo().getValue(), date, location, new ArrayList<>(), pollenDailyInfo.getPlantDescription().getCrossReaction(), pollenDailyInfo.getIndexInfo().getIndexDescription());
    }

    @Override
    public String toString() {
        return "Name : " + displayName + ", Index : " + index + "\n" + "Date : " + date + "\n" + "Location : " + location + "\n" + "Recommendation : " + recommendation + "\n" + "Cross : " + crossReaction;
    }
}
