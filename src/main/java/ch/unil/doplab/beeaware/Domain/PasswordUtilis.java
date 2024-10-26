package ch.unil.doplab.beeaware.Domain;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class PasswordUtilis {
    public static final int MAX_PASSWORD_LENGTH = 128;
    public static final int MIN_PASSWORD_LENGTH = 8;

    public static final int MIN_CATEGORIES_FOR_VALID_PASSWORD = 3;

    public static final Pattern upperConstraint = Pattern.compile(".*[A-Z].*");
    public static final Pattern lowerConstraint = Pattern.compile(".*[a-z].*");
    public static final Pattern numberConstraint = Pattern.compile(".*[0-9].*");
    public static final Pattern symbolConstraint = Pattern.compile(".*[~`!@#$%^&*()_\\-+={[}]|\\:;\"'<,>.?/].*");
    public static final List<Pattern> password_patterns = Collections.unmodifiableList(
            Arrays.asList(upperConstraint, lowerConstraint, numberConstraint, symbolConstraint));

    public static String hashPassword(String password) {
        if (checkPasswordConstraints(password))
            return BCrypt.withDefaults().hashToString(12, password.toCharArray());
        else throw new IllegalArgumentException("Password doesn't meet contraints, it should at minimum contains 3 of the followings contrains :\n - Lower char\n - Upper char\n - Number\n - Special char");
    }

    public static boolean checkPassword(String password, String bcryptHashString) {
        return BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString).verified;
    }
    public static boolean checkPasswordConstraints(String password) {
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
