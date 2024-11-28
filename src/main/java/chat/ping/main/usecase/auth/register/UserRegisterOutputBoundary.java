package chat.ping.main.usecase.auth.register;

import chat.ping.main.entity.user.User;


/**
 * Output boundary for the User Registration use case.
 * Defines methods for preparing responses for different scenarios.
 */
public interface UserRegisterOutputBoundary
{

    /**
     * Prepares the success response view for user registration.
     *
     * @param user The registered user entity.
     */
    void prepareSuccessView(User user);

    /**
     * Prepares the error response view when the username is already taken.
     *
     * @param username The username that is already taken.
     */
    void prepareUsernameAlreadyExistsView(String username);

    /**
     * Prepares the error response view when the email is already registered.
     *
     * @param email The email that is already registered.
     */
    void prepareEmailAlreadyExistsView(String email);

    /**
     * Prepares the error response view for an invalid password.
     *
     * @param errorMessage A detailed error message describing the issue.
     */
    void prepareInvalidPasswordView(String errorMessage);

    /**
     * Prepares the error response view for an invalid email format.
     *
     * @param email The email that has an invalid format.
     */
    void prepareInvalidEmailFormatView(String email);
}
