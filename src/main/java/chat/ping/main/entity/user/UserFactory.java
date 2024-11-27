package chat.ping.main.entity.user;



public class UserFactory
{
    public User createUser(String email, String username, String password)
    {
        return new User(email, username, password);
    }
}
