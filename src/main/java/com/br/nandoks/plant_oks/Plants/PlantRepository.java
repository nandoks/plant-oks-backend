package com.br.nandoks.plant_oks.Plants;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    Collection<Plant> findAllByCommomNameContainsIgnoreCaseOrBinomialNameContainsIgnoreCase(String text, String text1);
}
