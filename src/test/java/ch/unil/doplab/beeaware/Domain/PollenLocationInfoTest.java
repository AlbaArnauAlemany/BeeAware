package ch.unil.doplab.beeaware.Domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PollenLocationInfoTest {

    @Test
    void testPollenLocationInfoCreation() {
        PollenLocationInfo.Color color = new PollenLocationInfo.Color(0.4, 0.5);
        PollenLocationInfo.IndexInfo indexInfo = new PollenLocationInfo.IndexInfo("POLLEN_INDEX", "Pollen Index", 5, "Moderate", "Moderate pollen levels", color);
        PollenLocationInfo.PlantDescription plantDescription = new PollenLocationInfo.PlantDescription("Flower", "Asteraceae", "Spring", "Yellow", "Round", "None", "url/to/picture", "url/to/closeup");
        PollenLocationInfo.PlantInfo plantInfo = new PollenLocationInfo.PlantInfo("PLANT_1", "Plant One", true, indexInfo, plantDescription);
        PollenLocationInfo.PollenTypeInfo pollenTypeInfo = new PollenLocationInfo.PollenTypeInfo("HAZEL", "Hazel", true, indexInfo, Collections.singletonList("Avoid during peak season"));
        PollenLocationInfo.DailyInfo dailyInfo = new PollenLocationInfo.DailyInfo(new PollenLocationInfo.Date(2023, 11, 14), Arrays.asList(pollenTypeInfo), Arrays.asList(plantInfo));

        PollenLocationInfo pollenLocationInfo = new PollenLocationInfo("CH", Collections.singletonList(dailyInfo));

        assertEquals("CH", pollenLocationInfo.getRegionCode());
        assertNotNull(pollenLocationInfo.getDailyInfo());
        assertEquals(1, pollenLocationInfo.getDailyInfo().size());
        assertEquals(dailyInfo, pollenLocationInfo.getDailyInfo().get(0));
    }

    @Test
    void testDailyInfoCreation() {
        PollenLocationInfo.DailyInfo dailyInfo = new PollenLocationInfo.DailyInfo(new PollenLocationInfo.Date(2023, 11, 14), Collections.emptyList(), Collections.emptyList());

        assertNotNull(dailyInfo);
        assertEquals(2023, dailyInfo.getDate().getYear());
        assertEquals(11, dailyInfo.getDate().getMonth());
        assertEquals(14, dailyInfo.getDate().getDay());
    }

    @Test
    void testPollenTypeInfoCreation() {
        PollenLocationInfo.PollenTypeInfo pollenTypeInfo = new PollenLocationInfo.PollenTypeInfo("HAZEL", "Hazel", true, null, Collections.emptyList());

        assertEquals("HAZEL", pollenTypeInfo.getCode());
        assertEquals("Hazel", pollenTypeInfo.getDisplayName());
        assertTrue(pollenTypeInfo.getInSeason());
        assertTrue(pollenTypeInfo.getHealthRecommendations().isEmpty());
    }

    @Test
    void testPlantInfoCreation() {
        PollenLocationInfo.PlantInfo plantInfo = new PollenLocationInfo.PlantInfo("PLANT_1", "Plant One", true, null, null);

        assertEquals("PLANT_1", plantInfo.getCode());
        assertEquals("Plant One", plantInfo.getDisplayName());
        assertTrue(plantInfo.getInSeason());
    }
}