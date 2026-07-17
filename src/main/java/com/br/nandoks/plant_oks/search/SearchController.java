package com.br.nandoks.plant_oks.search;

import com.br.nandoks.plant_oks.Plants.PlantRepository;
import com.br.nandoks.plant_oks.classification.Classification;
import com.br.nandoks.plant_oks.classification.ClassificationRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    private final PlantRepository plantRepository;
    private final ClassificationRepository classificationRepository;

    public SearchController(PlantRepository plantRepository, ClassificationRepository classificationRepository) {
        this.plantRepository = plantRepository;
        this.classificationRepository = classificationRepository;
    }

    @QueryMapping
    public List<Object> search(@Argument String text){
        List<Object> results = new ArrayList<>();
        results.addAll(plantRepository.findAllByCommomNameContainsIgnoreCaseOrBinomialNameContainsIgnoreCase(text, text));
        results.addAll(classificationRepository.findAllByFamilyContainsIgnoreCase(text));
        return results;
    }

}
