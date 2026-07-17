package com.br.nandoks.plant_oks.classification;

import com.br.nandoks.plant_oks.Plants.Plant;
import com.br.nandoks.plant_oks.enums.Family;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="classifications")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Classification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "classification")
    private List<Plant> plant;

    private String family;

}
