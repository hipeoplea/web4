package org.example.web4.services;

import org.example.web4.dataBase.PointRepository;
import org.example.web4.dataBase.models.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.erhlc.ElasticsearchRestTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    private final PointRepository pointRepository;
    private final ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    public SessionService(PointRepository pointRepository, ElasticsearchRestTemplate elasticsearchRestTemplate) {
        this.pointRepository = pointRepository;
        this.elasticsearchRestTemplate = elasticsearchRestTemplate;
    }

    public Point addPoint(Point point) {
        return pointRepository.save(point);
    }

    public List<Point> getUserPoints() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication != null ? authentication.getName() : null;
        if (username != null) {
            return pointRepository.findByUserId(username);
        }
        throw new RuntimeException("User not authenticated");
    }
}
