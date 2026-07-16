package com.br.nandoks.plant_oks.classification;

import com.br.nandoks.plant_oks.Plants.Plant;
import com.br.nandoks.plant_oks.enums.Family;
import com.br.nandoks.plant_oks.enums.Genus;
import com.br.nandoks.plant_oks.enums.PlantType;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="classifications")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Classification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @Nullable
    private Plant plant;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private Family family;

    @Enumerated(EnumType.STRING)
    @Nullable
    private Genus genus;

    @Enumerated(EnumType.STRING)
    @Nullable
    private PlantType planType;

}
