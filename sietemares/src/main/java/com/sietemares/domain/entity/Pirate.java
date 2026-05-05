package com.sietemares.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "pirate")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pirate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "bounty")
    private Double bounty;

    @Column(name = "crew")
    private String crew;

    @Column(name = "is_alive")
    private Boolean isAlive;
}
