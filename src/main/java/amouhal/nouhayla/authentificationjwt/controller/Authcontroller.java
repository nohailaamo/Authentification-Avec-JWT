package amouhal.nouhayla.authentificationjwt.controller;

import amouhal.nouhayla.authentificationjwt.model.AuthRequest;
import amouhal.nouhayla.authentificationjwt.model.AuthResponse;
import amouhal.nouhayla.authentificationjwt.service.Jwtservice;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Authcontroller {
    private final AuthenticationManager authenticationManager;
    private final Jwtservice jwtService;
    private final UserDetailsService userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = uds;
    }
    @PostMapping("/auth/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        var auth = new UsernamePasswordAuthenticationToken(req.username(), req.password());
        authenticationManager.authenticate(auth);
        String token = jwtService.generateToken(user.getUsername(), Map.of("roles", user.getAuthorities()));
        return new AuthResponse(token);
    }
    @GetMapping("/hello")
    public Map<String, String> hello() {
    }
}
