package org.example.web4.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.example.web4.dataBase.models.Points;
import lombok.experimental.FieldDefaults;
import org.example.web4.dataBase.PointRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SessionService {
    PointRepository pointRepository;

    public Points addPoint(Points points) {
        return pointRepository.save(points);
    }

    public List<Points> getUserPoints() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication != null ? authentication.getName() : null;
        if (username != null) {
            return pointRepository.findByUserId(username);
        }
        throw new RuntimeException("User not authenticated");
    }
}
