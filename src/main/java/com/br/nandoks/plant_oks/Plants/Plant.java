package com.br.nandoks.plant_oks.Plants;

import com.br.nandoks.plant_oks.care.Care;
import com.br.nandoks.plant_oks.classification.Classification;
import com.br.nandoks.plant_oks.enums.*;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "plants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String description;
    @NotNull
    private String commomName;
    @NotNull
    private String binomialName;

    private String slug;

    @ManyToOne(fetch = FetchType.LAZY)
    private Classification classification;

    @OneToOne(fetch = FetchType.LAZY)
    @Nullable
    private Care care;

    private String fruitSeason;

    private String propagationMethod;

    private String maintenanceLevel;

    private String maintenanceDetails;


}


