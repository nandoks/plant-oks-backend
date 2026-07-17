package com.br.nandoks.plant_oks.classification;

import com.br.nandoks.plant_oks.Plants.Plant;
import com.br.nandoks.plant_oks.enums.Family;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ClassificationController {

    private ClassificationRepository classificationRepository;


    public ClassificationController(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @QueryMapping
    public List<Classification> classifications(){
        return classificationRepository.findAll();
    }

    @MutationMapping
    public Classification addClassification(@Argument ClassificationInput classificationInput){
        System.out.printf(classificationInput.family());
        var classification = new Classification();
        classification.setFamily(classificationInput.family());
        return classificationRepository.save(classification);
    }

    @BatchMapping
    public List<List<Plant>> plants(List<Plant> plants){
        List<Long> plantsIds = plants.stream()
                .map(Plant::getId)
                .toList();
        List<Plant> allClassifications = classificationRepository.findByPlantIdIn(plantsIds);

        Map<Long, List<Plant>> plantsByClassificationId = allClassifications.stream()
                .collect(Collectors.groupingBy(plant -> plant.getClassification().getId()));
        return plants.stream()
                .map(classification -> plantsByClassificationId.getOrDefault(classification.getId(), Collections.emptyList()))
                .toList();
    }

}
