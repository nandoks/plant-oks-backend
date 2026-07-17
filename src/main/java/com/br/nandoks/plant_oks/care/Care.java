package com.br.nandoks.plant_oks.care;

import com.br.nandoks.plant_oks.Plants.Plant;
import com.br.nandoks.plant_oks.enums.Level;
import com.br.nandoks.plant_oks.enums.Season;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="cares")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Care {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private Plant plant;

    @Nullable
    private Integer max_temperature;
    @Nullable
    private Integer min_temperature;
    @Nullable
    private Integer min_ph;
    @Nullable
    private Integer max_ph;
    @Nullable
    private Integer min_humidity;
    @Nullable
    private Integer max_humidity;

    @Nullable
    private Season prunningSeason;


    @Enumerated(EnumType.STRING)
    @Nullable
    private Level wateringRecurrence;

}
