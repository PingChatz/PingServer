//package chat.ping.main.presentation.controller;
//
//
//import chat.ping.main.domain.UserDao;
//import chat.ping.main.infrastructure.JWTUtils;
//import chat.ping.main.presentation.dto.AuthRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/auth")
//@RequiredArgsConstructor
//public class AuthController
//{
//    private final AuthenticationManager authenticationManager;
//    private final UserDao userDao;
//    private final JWTUtils jwtUtils;
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<String> authenticate(@RequestBody AuthRequest request)
//    {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
//        );
//
//        final UserDetails userDetails = userDao.findUserByEmail(request.getUsername());
//
//        if (userDetails != null)
//        {
//            return ResponseEntity.ok(jwtUtils.generateToken(userDetails, Map.of()));
//        }
//        return ResponseEntity.status(400).body("Some Error Has Occurred");
//    }
//
//}
