package ch.unil.doplab.beeaware.Domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PollenLocationIndexTest {

    @Test
    void testPollenLocationIndexCreation() {
        // Créer des objets pour les tests
//        PollenLocationIndex.Color color = new PollenLocationIndex.Color(0.4, 0.5);
//        PollenLocationIndex.IndexInfo indexInfo = new PollenLocationIndex.IndexInfo("POLLEN_INDEX", "Pollen Index", 5, "Moderate", "Moderate pollen levels", color);
//        PollenLocationIndex.PlantDescription plantDescription = new PollenLocationIndex.PlantDescription("Flower", "Asteraceae", "Spring", "Yellow", "Round", "None", "url/to/picture", "url/to/closeup");
//        PollenLocationIndex.PlantInfo plantInfo = new PollenLocationIndex.PlantInfo("PLANT_1", "Plant One", true, indexInfo, plantDescription);
//        PollenLocationIndex.PollenTypeInfo pollenTypeInfo = new PollenLocationIndex.PollenTypeInfo("HAZEL", "Hazel", true, indexInfo, Collections.singletonList("Avoid during peak season"));
//        PollenLocationIndex.DailyInfo dailyInfo = new PollenLocationIndex.DailyInfo(new PollenLocationIndex.Date(2023, 11, 14), Arrays.asList(pollenTypeInfo), Arrays.asList(plantInfo));
//
//        // Instance of PollenLocationIndex
//        PollenLocationIndex pollenLocationIndex = new PollenLocationIndex(1L, "CH", Collections.singletonList(dailyInfo), new Location());
//
//        // Vérification des valeurs
//        assertEquals(1L, pollenLocationIndex.getId());
//        assertEquals("CH", pollenLocationIndex.getRegionCode());
//        assertNotNull(pollenLocationIndex.getDailyInfo());
//        assertEquals(1, pollenLocationIndex.getDailyInfo().size());
//        assertEquals(dailyInfo, pollenLocationIndex.getDailyInfo().get(0));
    }

    @Test
    void testDailyInfoCreation() {
//        PollenLocationIndex.DailyInfo dailyInfo = new PollenLocationIndex.DailyInfo(new PollenLocationIndex.Date(2023, 11, 14), Collections.emptyList(), Collections.emptyList());
//
//        assertNotNull(dailyInfo);
//        assertEquals(2023, dailyInfo.getDate().getYear());
//        assertEquals(11, dailyInfo.getDate().getMonth());
//        assertEquals(14, dailyInfo.getDate().getDay());
    }

    @Test
    void testPollenTypeInfoCreation() {
//        PollenLocationIndex.PollenTypeInfo pollenTypeInfo = new PollenLocationIndex.PollenTypeInfo("HAZEL", "Hazel", true, null, Collections.emptyList());
//
//        assertEquals("HAZEL", pollenTypeInfo.getCode());
//        assertEquals("Hazel", pollenTypeInfo.getDisplayName());
//        assertTrue(pollenTypeInfo.getInSeason());
//        assertTrue(pollenTypeInfo.getHealthRecommendations().isEmpty());
    }

    @Test
    void testPlantInfoCreation() {
//        PollenLocationIndex.PlantInfo plantInfo = new PollenLocationIndex.PlantInfo("PLANT_1", "Plant One", true, null, null);
//
//        assertEquals("PLANT_1", plantInfo.getCode());
//        assertEquals("Plant One", plantInfo.getDisplayName());
//        assertTrue(plantInfo.getInSeason());
    }
}