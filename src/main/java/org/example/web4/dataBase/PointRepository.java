package org.example.web4.dataBase;

import org.example.web4.dataBase.models.Points;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PointRepository extends JpaRepository<Points, UUID> {
    List<Points> findByUserId(String userId);
}
