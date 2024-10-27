package ch.unil.doplab.beeaware.Domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import lombok.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static ch.unil.doplab.beeaware.Utilis.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollenLocationIndex {
    private Long id;
    private static final String APIKEY = ResourceBundle.getBundle("application").getString("API_KEY");
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

    public static void pollenForecast(Location location, int days) {
        String url = String.format(
                "https://pollen.googleapis.com/v1/forecast:lookup?key=%s&location.longitude=%s&location.latitude=%s&days=%s",
                APIKEY, location.getLongitude(), location.getLatitude(), days);

        try {
            NetHttpTransport httpTransport = new NetHttpTransport();
            HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
            HttpRequest request = requestFactory.buildGetRequest(new com.google.api.client.http.GenericUrl(url));
            HttpResponse response = request.execute();

            String jsonResponse = response.parseAsString();
            ObjectMapper objectMapper = new ObjectMapper();
            PollenLocationIndex pollenInfo = objectMapper.readValue(jsonResponse, PollenLocationIndex.class);
            pollenInfo.setLocation(location);
            pollenInfo.setId(idPollenIndex++);
            addPollenIndexLocation(pollenInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        String pollenIndex = "";

        for (PollenLocationIndex.DailyInfo dailyInfo : dailyInfo) {
            for (PollenLocationIndex.PollenTypeInfo pollenTypeDailyInfo : dailyInfo.getPollenTypeInfo()) {
                if(pollenTypeDailyInfo.getIndexInfo() != null) {
                    pollenIndex +=
                        pollenTypeDailyInfo.getDisplayName() + "\n" +
                        pollenTypeDailyInfo.getIndexInfo().getValue() + "\n" +
                        pollenTypeDailyInfo.getIndexInfo().getIndexDescription() + "\n";
                }
            }
            for (PollenLocationIndex.PlantInfo pollenDailyInfo : dailyInfo.getPlantInfo()) {
                if(pollenDailyInfo.getIndexInfo() != null) {
                    pollenIndex +=
                        pollenDailyInfo.getDisplayName() + "\n" +
                        pollenDailyInfo.getIndexInfo().getValue() + "\n" +
                        pollenDailyInfo.getIndexInfo().getIndexDescription() + "\n";
                }
            }
        }

        return pollenIndex;
    }

}