package org.example.web4.dataBase.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@Table(name = "points")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
public class Points {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    UUID id;
    String userId;
    float x;
    float y;
    float r;
    boolean ishit;
}
