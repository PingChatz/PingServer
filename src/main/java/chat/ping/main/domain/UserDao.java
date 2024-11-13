//package chat.ping.main.domain;
//
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Repository;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//@Repository
//public class UserDao
//{
//
//    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//    private static final List<UserDetails> APPLICATION_USERS = Arrays.asList(
//            new User(
//                    "alirahbar2005@gmail.com",
//                    encoder.encode("password"), // encode the password
//                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
//            ),
//            new User(
//                    "alex@gmail.com",
//                    encoder.encode("1230"), // encode the password
//                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
//            )
//    );
//
//    public UserDetails findUserByEmail(String email)
//    {
//        return APPLICATION_USERS
//                .stream()
//                .filter(u -> u.getUsername().equals(email))
//                .findFirst()
//                .orElseThrow(() -> new UsernameNotFoundException(email));
//    }
//
//}
