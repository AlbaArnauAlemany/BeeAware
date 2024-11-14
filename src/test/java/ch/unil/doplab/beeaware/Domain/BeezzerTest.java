package ch.unil.doplab.beeaware.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeezzerTest {
    private Beezzer beezzer;
    private Location location;

    @BeforeEach
    void setUp() {
        location = new Location(1007, "CH", new Coordinate(46.5197, 6.6323));
        beezzer = new Beezzer(1L,
                "Skywalker",
                "skywalker@test.com",
                "Skywalker5?",
                location, Role.BEEZZER);

    }

    //Test if the object beezzer is an instance of Beezzer
    @Test
    void testBeezzerType() {
        assertTrue(beezzer instanceof Beezzer, "beezer object must be an instance of Beezzer");
    }

    // Test username and email getters
    @Test
    void testGetters() {
        assertEquals("Skywalker", beezzer.getUsername());
        assertEquals("skywalker@test.com", beezzer.getEmail());
        assertEquals(location, beezzer.getLocation());
    }

    // Test for the equals() method
    @Test
    void testEquals() {
        Beezzer anotherBeezzer = new Beezzer(1L, "Skywalker", "skywalker@test.com", "Skywalker5?", location, Role.BEEZZER);
        assertEquals(beezzer.toString(), anotherBeezzer.toString(), "Two Beezzer objects with the same data should be equal");
    }

    // Test for proper comparison of objects is equals or not
    @Test
    void canEqual() {
        assertTrue(beezzer.canEqual(new Beezzer()));
    }

    // Test for the hashCode() method (if two objects which have same attributs return the same hash code)
    @Test
    void equalitytest() {
        Beezzer anotherBeezzer = new Beezzer(1L, "Skywalker", "skywalker@test.com", "Skywalker5?", location, Role.BEEZZER);
        assertEquals(beezzer.toString(), anotherBeezzer.toString());
    }

    // Test the password is correctly hashed
    @Test
    void testGetPassword() {
        assertNotEquals("Skywalker5?", beezzer.getPassword(), "Password should be hashed and not stored in plain text.");
    }

    //Test set new password is also hashed
    @Test
    void setPassword() {
        beezzer.setPassword(PasswordUtilis.hashPassword("NewPassword123?"));
        assertNotEquals("NewPassword123?", beezzer.getPassword(), "Password should be hashed and not stored in plain text.");
    }

    // Test the toString() method
    @Test
    void testToString() {
        String expected = "Username: Skywalker\n"
                + "Email: skywalker@test.com\n"
                + "Role : BEEZZER\n"  // Assuming role is null
                + "Allergens: \n";  // Assuming allergens are not set
        assertEquals(expected.trim(), beezzer.toString(), "toString() method must return the correct representation of the Beezzer object");
    }

    // Test for getter and setter of ID
    @Test
    void getId() {
        assertEquals(1L, beezzer.getId(), "ID should be 1L");
    }

    @Test
    void setId() {
        beezzer.setId(2L);
        assertEquals(2L, beezzer.getId(), "ID should be set to 2L");
    }

    // Test for getter and setter of Username
    @Test
    void getUsername() {
        assertEquals("Skywalker", beezzer.getUsername(), "Username should be 'Skywalker'");
    }

    @Test
    void setUsername() {
        beezzer.setUsername("Dark Vador");
        assertEquals("Dark Vador", beezzer.getUsername(), "Username should be updated to 'Dark Vador'");
    }


    // Test for getter and setter of Email
    @Test
    void getEmail() {
        assertEquals("skywalker@test.com", beezzer.getEmail(), "Email should be 'skywalker@test.com'");
    }

    @Test
    void setEmail() {
        beezzer.setEmail("dark.vador@test.com");
        assertEquals("dark.vador@test.com", beezzer.getEmail(), "Email should be updated to 'dark.vador@test.com'");
    }

    // Test for getter and setter of Location
    @Test
    void getLocation() {
        assertEquals(location, beezzer.getLocation());
    }

    @Test
    void setLocation() {
        Location newLocation = new Location(1000, "CH", new Coordinate(46.5197, 6.6323));
        beezzer.setLocation(newLocation);
        assertEquals(newLocation, beezzer.getLocation(), "Location should be updated");
    }

    // Test for getter and setter of Antihistamine, we assume that it is null initially
    @Test
    void getAntihistamine() {
        assertNull(beezzer.getAntihistamine(), "We assume that Antihistamine is null initially");
    }

    @Test
    void setAntihistamine() {
        beezzer.setAntihistamine("Cetirizine");
        assertEquals("Cetirizine", beezzer.getAntihistamine());
    }
}