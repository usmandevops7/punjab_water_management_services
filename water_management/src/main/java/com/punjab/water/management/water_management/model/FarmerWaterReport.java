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
public class FarmerWaterReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer report_id;

    @Column(nullable = false)
    private Integer farmer_id;

    @Column(nullable = false)
    private Integer uc_id;

    @Column(nullable = false)
    private Integer terrain_id;

    @Column(nullable = false)
    private Integer season_id;

    private Integer wish_crop_id;

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
    private UnionCouncil unionCouncil;

}
