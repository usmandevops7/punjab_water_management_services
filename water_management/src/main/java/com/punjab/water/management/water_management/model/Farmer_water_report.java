package com.punjab.water.management.water_management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Set;
import java.time.LocalDateTime;

@Entity
@Table(name = "farmer_water_report")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Farmer_water_report {

    @Id
    @Column(nullable = false)
    private String report_id;

    @Column(nullable = false)
    private String farmer_id;

    @Column(nullable = false)
    private String uc_id;

    @Column(nullable = false)
    private String terrain_id;

    @Column(nullable = false)
    private String season_id;

    private String wish_crop_id;

    private LocalDateTime generated_on;

    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wish_crop_id")
    private Crop crop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    private Season season;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terrain_id")
    private Terrain terrain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uc_id")
    private Union_council union_council;

}
