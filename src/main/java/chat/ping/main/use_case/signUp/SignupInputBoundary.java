package chat.ping.main.use_case.signUp;
/**
 * Input Boundary for actions which are related to signing up.
 */
public interface SignupInputBoundary {

    /**
     * Executes the Signup use case.
     * @param signupInputData the input data
     */
    void execute(SignupInputData signupInputData);

    /**
     * Executes the switch to login view use case.
     */
    void switchToLoginView();
}


