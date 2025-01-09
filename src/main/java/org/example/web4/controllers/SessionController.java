package org.example.web4.controllers;

import org.example.web4.dataBase.models.Point;
import org.example.web4.services.SessionService;
import org.example.web4.utill.AreaCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.example.web4.utill.Validation;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @PostMapping("/add")
    public Point addPoint(@RequestParam float x, @RequestParam float y, @RequestParam float r) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication != null ? authentication.getName() : null;
        if (Validation.validate(x, y, r)){
            Point point = new Point();
            point.setUserId(username);
            point.setX(x);
            point.setY(y);
            point.setR(r);
            point.setIshit(AreaCheck.isInArea(x, y, r));
            return sessionService.addPoint(point);
        }
        throw new RuntimeException("Вы обманули фронт");
    }

    @GetMapping("/user")
    public List<Point> getPointsByUser() {
        return sessionService.getUserPoints();
    }
}
