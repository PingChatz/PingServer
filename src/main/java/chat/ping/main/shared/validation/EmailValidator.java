package chat.ping.main.shared.validation;

import chat.ping.main.entity.user.exception.InvalidCredentialsException;

import java.util.regex.Pattern;

public class EmailValidator
{
    // Regular expression for email validation
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Checks if the given string is a valid email.
     *
     * @param email The email to validate.
     * @return True if valid, false otherwise.
     */
    public static boolean isValid(String email)
    {
        if (email == null || email.trim().isEmpty())
        {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Validates the email and throws an exception if invalid.
     *
     * @param email The email to validate.
     * @throws InvalidCredentialsException if email is invalid.
     */
    public static void validate(String email)
    {
        if (!isValid(email))
        {
            throw new InvalidCredentialsException("Invalid email format.");
        }
    }
}
