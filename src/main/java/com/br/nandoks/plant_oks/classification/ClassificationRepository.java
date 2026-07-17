package com.br.nandoks.plant_oks.classification;

import com.br.nandoks.plant_oks.Plants.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

@
public interface ClassificationRepository extends JpaRepository<Classification, Long> {
    Collection<Classification> findAllByFamilyContainsIgnoreCase(String text);

    List<Plant> findByPlantIdIn(List<Long> plantsIds);
}
