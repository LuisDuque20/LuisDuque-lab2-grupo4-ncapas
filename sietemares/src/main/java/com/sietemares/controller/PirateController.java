package com.sietemares.controller;

import com.sietemares.domain.entity.Pirate;
import com.sietemares.service.impl.PirateServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pirates")
@AllArgsConstructor
public class PirateController {

    private final PirateServiceImpl pirateService;

    // CREATE
    @PostMapping
    public ResponseEntity<Pirate> createPirate(@RequestBody Pirate pirate) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pirateService.createPirate(pirate));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Pirate>> getAllPirates() {
        return ResponseEntity.ok(pirateService.getAllPirates());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Pirate> getPirateById(@PathVariable UUID id) {
        return ResponseEntity.ok(pirateService.getPirateById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Pirate> updatePirate(
            @PathVariable UUID id,
            @RequestBody Pirate pirate
    ) {
        return ResponseEntity.ok(pirateService.updatePirate(id, pirate));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePirate(@PathVariable UUID id) {
        pirateService.deletePirate(id);
        return ResponseEntity.noContent().build();
    }
}
