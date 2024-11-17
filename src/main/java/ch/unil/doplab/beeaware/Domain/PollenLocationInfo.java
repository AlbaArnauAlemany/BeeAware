package ch.unil.doplab.beeaware.Domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollenLocationInfo {
    private String regionCode = "UNKNOWN";
    private List<DailyInfo> dailyInfo = new ArrayList<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DailyInfo {
        private Date date;
        private List<PollenTypeInfo> pollenTypeInfo;
        private List<PlantInfo> plantInfo;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Date {
        private int year = 0;
        private int month = 0;
        private int day = 0;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PollenTypeInfo {
        private String code = "UNKNOWN";
        private String displayName = "Unknown Pollen";
        private Boolean inSeason = false;
        private IndexInfo indexInfo = new IndexInfo();
        private List<String> healthRecommendations = new ArrayList<>();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IndexInfo {
        private String code = "N/A";
        private String displayName = "Unknown Index";
        private int value = 0;
        private String category = "Uncategorized";
        private String indexDescription = "No description";
        private Color color = new Color(0.0, 0.0);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Color {
        private double green = 0.0;
        private double blue = 0.0;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PlantInfo {
        private String code = "UNKNOWN";
        private String displayName = "Unknown Plant";
        private Boolean inSeason = false;
        private IndexInfo indexInfo = new IndexInfo();
        private PlantDescription plantDescription = new PlantDescription();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PlantDescription {
        private String type = "Unknown Type";
        private String family = "Unknown Family";
        private String season = "Unknown Season";
        private String specialColors = "No Special Colors";
        private String specialShapes = "No Special Shapes";
        private String crossReaction = "None";
        private String picture = "No Picture";
        private String pictureCloseup = "No Closeup";
    }
}