package com.labo2ncapas.service.impl;


import com.labo2ncapas.domain.entity.Pirate;
import com.labo2ncapas.repository.PirateRepository;
import com.labo2ncapas.service.PirateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PirateServiceImpl implements PirateService {

    private final PirateRepository pirateRepository;

    @Override
    public Pirate createPirate(Pirate pirate) {
        return pirateRepository.save(pirate);
    }

    @Override
    public List<Pirate> getAllPirates() {
        return pirateRepository.findAll();
    }

    @Override
    public Pirate getPirateById(UUID id) {
        return pirateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pirate not found"));
    }

    @Override
    public Pirate updatePirate(UUID id, Pirate pirate) {
        Pirate existing = getPirateById(id);

        existing.setName(pirate.getName());
        existing.setBounty(pirate.getBounty());
        existing.setCrew(pirate.getCrew());
        existing.setIsAlive(pirate.getIsAlive());

        return pirateRepository.save(existing);
    }

    @Override
    public void deletePirate(UUID id) {
        pirateRepository.deleteById(id);
    }
}
