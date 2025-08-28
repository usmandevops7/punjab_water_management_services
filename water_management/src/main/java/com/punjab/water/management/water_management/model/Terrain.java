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
    @Column(nullable = false)
    private String terrain_id;

    @Column(nullable = false)
    private String uc_id;

    @Column(nullable = false)
    private String soil_type;

    @Column(nullable = false)
    private String land_type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uc_id")
    private Union_council union_council;

}
