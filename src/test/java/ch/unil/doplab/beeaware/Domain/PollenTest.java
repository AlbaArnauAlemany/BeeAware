package ch.unil.doplab.beeaware.Domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PollenTest {

    @Test
    void testGetPredefinedPollens() {
        Set<Pollen> pollens = Pollen.getPredefinedPollens();
        assertNotNull(pollens, "Predefined pollens should not be null");
        assertFalse(pollens.isEmpty(), "Predefined pollens should not be empty");
        assertEquals(12, pollens.size(), "12 predefined pollen types");
    }

    @Test
    void testGetPollenByName_ValidName() {
        Pollen hazel = Pollen.getPollenByName("Hazel");
        assertNotNull(hazel, "The pollen should not be null");
        assertEquals(0L, hazel.getId(), "The ID of Hazel should be 0");
        assertEquals("Hazel", hazel.getPollenNameEN(), "The name of pollen should be 'Hazel'");
    }

    @Test
    void testGetPollenByName_InvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Pollen.getPollenByName("StrangePollen");
        });
        assertEquals("This pollen is not predefined: StrangePollen", exception.getMessage());
    }

    @Test
    void testGetPollenByName_NullName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Pollen.getPollenByName(null);
        });
        assertEquals("This pollen is not predefined: null", exception.getMessage());
    }
}
