package org.example.web4.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.web4.dataBase.models.Points;
import org.example.web4.services.SessionService;
import org.example.web4.utill.AreaCheck;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.example.web4.utill.Validation;
import java.util.List;

@RestController
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SessionController {
    SessionService sessionService;

    @PostMapping("/add")
    public Points addPoint(@RequestParam float x, @RequestParam float y, @RequestParam float r) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication != null ? authentication.getName() : null;
        if (Validation.validate(x, y, r)){
            Points points = new Points();
            points.setUserId(username);
            points.setX(x);
            points.setY(y);
            points.setR(r);
            points.setIshit(AreaCheck.isInArea(x, y, r));
            return sessionService.addPoint(points);
        }
        throw new RuntimeException("Вы обманули фронт");
    }

    @GetMapping("/user")
    public List<Points> getPointsByUser() {
        return sessionService.getUserPoints();
    }
}
