package com.punjab.water.management.water_management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "terrain")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer terrain_id;

    @Column(nullable = false)
    private Integer uc_id;

    @Column(nullable = false)
    private String soil_type;

    @Column(nullable = false)
    private String land_type;

    @Column(columnDefinition = "geometry")
    private String boundary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uc_id")
    private UnionCouncil unionCouncil;

}
