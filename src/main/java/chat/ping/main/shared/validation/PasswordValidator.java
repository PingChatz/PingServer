package chat.ping.main.shared.validation;

import chat.ping.main.entity.user.exception.InvalidPasswordException;

import java.util.regex.Pattern;

public class PasswordValidator
{
    // Define password rules
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 32;
    private static final String SPECIAL_CHARACTER_REGEX = "[^a-zA-Z0-9]";
    private static final String DIGIT_REGEX = "\\d";
    private static final String UPPERCASE_REGEX = "[A-Z]";
    private static final String LOWERCASE_REGEX = "[a-z]";

    public static boolean isValid(String password) {
        // Null or empty check
        if (password == null || password.trim().isEmpty()) {
            throw new InvalidPasswordException("Password cannot be empty.");
        }

        // Length validation
        if (password.length() < MIN_LENGTH || password.length() > MAX_LENGTH) {
            throw new InvalidPasswordException("Password must be between " + MIN_LENGTH + " and " + MAX_LENGTH + " characters.");
        }

        // Special character validation
        if (!Pattern.compile(SPECIAL_CHARACTER_REGEX).matcher(password).find()) {
            throw new InvalidPasswordException("Password must contain at least one special character.");
        }

        // Digit validation
        if (!Pattern.compile(DIGIT_REGEX).matcher(password).find()) {
            throw new InvalidPasswordException("Password must contain at least one digit.");
        }

        // Uppercase letter validation
        if (!Pattern.compile(UPPERCASE_REGEX).matcher(password).find()) {
            throw new InvalidPasswordException("Password must contain at least one uppercase letter.");
        }

        // Lowercase letter validation
        if (!Pattern.compile(LOWERCASE_REGEX).matcher(password).find()) {
            throw new InvalidPasswordException("Password must contain at least one lowercase letter.");
        }

        return true;
    }
}
