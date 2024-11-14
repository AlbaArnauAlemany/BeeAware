package ch.unil.doplab.beeaware.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
public class PollenLocationIndex {
    private Long id;
    private String displayName;
    private int index;
    private Date date;
    private Location location;
    private List<String> recommendation;
    private String crossReaction;


    PollenLocationIndex(String displayName, int index, Date date, Location location, List<String> recommendation, String crossReaction){
        this.displayName = displayName;
        this.index = index;
        this.date = date;
        this.location = location;
        this.recommendation = recommendation;
        this.crossReaction = crossReaction;
    }
    public PollenLocationIndex(PollenLocationInfo.PollenTypeInfo pollenTypeDailyInfo, Date date, Location location) {
        this(pollenTypeDailyInfo.getDisplayName(), pollenTypeDailyInfo.getIndexInfo().getValue(), date, location, pollenTypeDailyInfo.getHealthRecommendations(), "");
    }

    public PollenLocationIndex(PollenLocationInfo.PlantInfo pollenDailyInfo, Date date, Location location) {
        this(pollenDailyInfo.getDisplayName(), pollenDailyInfo.getIndexInfo().getValue(), date, location, new ArrayList<>(), pollenDailyInfo.getPlantDescription().getCrossReaction());
    }

    @Override
    public String toString() {
        return "Name : " + displayName + ", Index : " + index + "\n" + "Date : " + date + "\n" + "Location : " + location + "\n" + "Recommandation : " + recommendation + "\n" + "Cross : " + crossReaction;
    }
}
