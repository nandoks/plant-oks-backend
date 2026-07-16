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

@Table(name = "plants")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String description;
    @NotNull
    private String commomName;
    @NotNull
    private String cientificName;

    @OneToOne(fetch = FetchType.LAZY)
    private Classification classification;

    @OneToOne(fetch = FetchType.LAZY)
    @Nullable
    private Care care;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private Season fruitSeason;

    @Enumerated(EnumType.STRING)
    private PropagationMethod propagationMethod;

    private String slug;

    @Enumerated(EnumType.STRING)
    private Level maintenanceLevel;

    private String maintenanceDetails;


}

