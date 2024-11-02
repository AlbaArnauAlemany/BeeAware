package ch.unil.doplab.beeaware.Domain;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Utility class for password-related operations, including hashing, verification,
 * and checking password constraints for strength and validity.
 * This class enforces minimum password standards by validating the inclusion of
 * uppercase & lowercase letters, numbers, and special characters.
 */
public class PasswordUtilis {
    /** The maximum allowed password length. */
    public static final int MAX_PASSWORD_LENGTH = 128;
    /** The minimum required password length. */
    public static final int MIN_PASSWORD_LENGTH = 8;
    /** The minimum number of character categories required for a valid password. */
    public static final int MIN_CATEGORIES_FOR_VALID_PASSWORD = 3;
    /** RegEx pattern to check for at least one uppercase letter. */
    public static final Pattern upperConstraint = Pattern.compile(".*[A-Z].*");
    /** RegEX pattern to check for at least one lowercase letter. */
    public static final Pattern lowerConstraint = Pattern.compile(".*[a-z].*");
    /** RegEx pattern to check for at least one numeric digit. */
    public static final Pattern numberConstraint = Pattern.compile(".*[0-9].*");
    /** RegEx pattern to check for at least one special character. */
    public static final Pattern symbolConstraint = Pattern.compile(".*[~`!@#$%^&*()_\\-+={[}]|\\:;\"'<,>.?/].*");

    /** List of all regular expression patterns used for password constraint checks. */
    public static final List<Pattern> password_patterns = Collections.unmodifiableList(
            Arrays.asList(upperConstraint, lowerConstraint, numberConstraint, symbolConstraint));

    /**
     * Hashes a given password using the BCrypt hashing algorithm.
     * This method hashes a password if it meets the minimum strength requirements
     * defined by {@link #checkPasswordConstraints(String)}.
     *
     * @param password The plain text password to be hashed.
     * @return The hashed password as a BCrypt string.
     * @throws IllegalArgumentException if the password does not meet the minimum constraints,
     *                                  which require at least three of the following:
     *                                  uppercase letters, lowercase letters, numbers, and special characters.
     */
    @NotNull
    public static String hashPassword(String password) {
        if (checkPasswordConstraints(password))
            return BCrypt.withDefaults().hashToString(12, password.toCharArray());
        else throw new IllegalArgumentException("Password doesn't meet the minimum strength requirements, it should at minimum contains 3 of the followings requirements :\n - Lower char\n - Upper char\n - Number\n - Special Character");
    }

    /**
     * Verifies a password against a previously hashed BCrypt string.
     *
     * @param password The plain text password to verify.
     * @param bcryptHashString The BCrypt previously hashed password to verify against.
     * @return {@code true} if the password matches the hash, {@code false} otherwise.
     */
    public static boolean checkPassword(@NotNull String password, String bcryptHashString) {
        return BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString).verified;
    }

    /**
     * Checks if a password meets the defined minimum strength requirements.
     * A password is considered valid if its length is within the allowed range, and
     * it contains characters from at least three of the following categories:
     * uppercase letters, lowercase letters, numbers, and special characters.
     *
     * @param password The password to validate.
     * @return {@code true} if the password meets the minimum strength requirements, {@code false} otherwise.
     */
    public static boolean checkPasswordConstraints(@NotNull String password) {
        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }
        int categories = 0;

        for (Pattern p : password_patterns) {
            if (p.matcher(password).find()) {
                categories++;
            }
        }

        return categories >= MIN_CATEGORIES_FOR_VALID_PASSWORD;
    }

}
