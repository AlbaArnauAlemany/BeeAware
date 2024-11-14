package ch.unil.doplab.beeaware.Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilisTest {

    @Test
    void testCheckPasswordConstraints_ValidPasswords() {
        assertTrue(PasswordUtilis.checkPasswordConstraints("Password1@"));
        assertTrue(PasswordUtilis.checkPasswordConstraints("StrongP@ssw0rd"));
        assertTrue(PasswordUtilis.checkPasswordConstraints("1234Abc!"));
    }

    @Test
    void testCheckPasswordConstraints_InvalidPasswords() {
        assertFalse(PasswordUtilis.checkPasswordConstraints("short"));
        assertFalse(PasswordUtilis.checkPasswordConstraints("NoNumbersOrSpecialChars"));
        assertFalse(PasswordUtilis.checkPasswordConstraints("12345678"));
        assertFalse(PasswordUtilis.checkPasswordConstraints("NoSpecialChars"));
    }

    @Test
    void testHashPassword_ValidPassword() {
        String password = "ValidPass1!";
        String hashedPassword = PasswordUtilis.hashPassword(password);
        assertNotNull(hashedPassword);
        assertTrue(PasswordUtilis.checkPassword(password, hashedPassword));
    }

    @Test
    void testHashPassword_InvalidPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PasswordUtilis.hashPassword("short");
        });
        assertEquals("Password doesn't meet the minimum strength requirements, it should at minimum contains 3 of the followings requirements :\n - Lower char\n - Upper char\n - Number\n - Special Character", exception.getMessage());
    }

    @Test
    void testCheckPassword() {
        String password = "Test!1234";
        String hashedPassword = PasswordUtilis.hashPassword(password);
        assertTrue(PasswordUtilis.checkPassword(password, hashedPassword));
        assertFalse(PasswordUtilis.checkPassword("WrongPassword", hashedPassword));
    }
}

