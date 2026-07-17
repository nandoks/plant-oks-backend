package com.br.nandoks.plant_oks.Plants;

import com.br.nandoks.plant_oks.classification.ClassificationRepository;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class PlantController {

    private final PlantRepository plantRepository;
    private final ClassificationRepository classificationRepository;

    public PlantController(PlantRepository plantRepository, ClassificationRepository classificationRepository) {
        this.plantRepository = plantRepository;
        this.classificationRepository = classificationRepository;
    }

    @QueryMapping
    public List<Plant> plants(){
        return plantRepository.findAll();
    }

    @QueryMapping
    public Optional<Plant> plant(@Argument Long id){
        return plantRepository.findById(id);
    }

    @MutationMapping
    public Plant addPlant(@Argument PlantInput plantInput){
        var classification = classificationRepository.findById(plantInput.classificationId()).orElseThrow();
        var plant = new Plant();
        plant.setBinomialName(plantInput.binomialName());
        plant.setCommomName(plantInput.commomName());
        plant.setDescription(plantInput.description());
        plant.setClassification(classification);
        return plantRepository.save(plant);
    }

}
