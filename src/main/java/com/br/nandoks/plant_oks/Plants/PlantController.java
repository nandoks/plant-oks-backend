package com.br.nandoks.plant_oks.Plants;

import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
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

    public PlantController(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @QueryMapping
    public List<Plant> plants(){
        return plantRepository.findAll();
    }

    @QueryMapping
    public Optional<Plant> plant(@Argument Long id){
        return plantRepository.findById(id);
    }

}
