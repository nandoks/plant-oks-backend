package com.br.nandoks.plant_oks.Plants;

public record PlantInput(
        String description,
        String commomName,
        Long classificationId,
        String binomialName
) {
}
