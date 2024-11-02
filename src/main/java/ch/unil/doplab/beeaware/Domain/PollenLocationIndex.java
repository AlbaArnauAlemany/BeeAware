package ch.unil.doplab.beeaware.Domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import lombok.*;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollenLocationIndex {
    private Long id;
    private String regionCode;
    private List<DailyInfo> dailyInfo;
    private Location location;

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
        private int year;
        private int month;
        private int day;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PollenTypeInfo {
        private String code;
        private String displayName;
        private Boolean inSeason;
        private IndexInfo indexInfo;
        private List<String> healthRecommendations;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IndexInfo {
        private String code;
        private String displayName;
        private int value;
        private String category;
        private String indexDescription;
        private Color color;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Color {
        private double green;
        private double blue;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PlantInfo {
        private String code;
        private String displayName;
        private Boolean inSeason;
        private IndexInfo indexInfo;
        private PlantDescription plantDescription;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PlantDescription {
        private String type;
        private String family;
        private String season;
        private String specialColors;
        private String specialShapes;
        private String crossReaction;
        private String picture;
        private String pictureCloseup;
    }

}