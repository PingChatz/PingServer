package chat.ping.main.domain.models;

public class UserFactory {
    /**
     * Creates a new User.
     * @param name the name of the new user
     * @param passwordHash the password of the new user
     * @return the new user
     */
    public User create(String name, String passwordHash, String email){
        return new User(name, passwordHash, email);
    };

}
