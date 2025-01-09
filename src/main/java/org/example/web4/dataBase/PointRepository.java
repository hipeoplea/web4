package org.example.web4.dataBase;

import org.example.web4.dataBase.models.Point;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends ElasticsearchRepository<Point, String> {
    List<Point> findByUserId(String userId);
}
