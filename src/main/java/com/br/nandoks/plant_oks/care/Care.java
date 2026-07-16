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

    private Integer max_temperature;
    private Integer min_temperature;
    private Integer min_ph;
    private Integer max_ph;
    private Integer min_humidity;
    private Integer max_humidity;
    private Season prunningSeason;
    private Level wateringRecurrence;



}
