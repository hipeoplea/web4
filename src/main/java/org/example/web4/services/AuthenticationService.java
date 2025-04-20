package org.example.web4.services;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.web4.dataBase.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import java.util.Date;
import java.util.Optional;
import org.example.web4.dataBase.models.User;

import javax.crypto.SecretKey;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthenticationService {
    UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder;

    public boolean authenticate(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return passwordEncoder.matches(password, user.getPasswordHash());
        }
        return false;
    }

    public void register(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }
        String passwordHash = passwordEncoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(passwordHash);
        userRepository.save(user);
    }

    public String generateToken(String username) {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 864_000_00))
                .signWith(SignatureAlgorithm.HS256, "VAtin0FhggFQw/sPZB398lYGPdlctgNPzOobshEw6Idiz0ekSqWgkwbO1Inv26lt")
                .compact();
    }

    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
