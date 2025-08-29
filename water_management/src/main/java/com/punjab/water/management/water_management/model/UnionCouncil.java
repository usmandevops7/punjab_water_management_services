package com.punjab.water.management.water_management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "union_council")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnionCouncil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer uc_id;

    @Column(nullable = false)
    private String uc_name;

    @Column(nullable = false)
    private Integer tehsil_id;

    @Column(nullable = false)
    private String us_name_ur;

    private Integer pp;

    private Integer na;

    @Column(columnDefinition = "geometry")
    private String boundary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tehsil_id")
    private Tehsil tehsil;

    @OneToMany(mappedBy = "unionCouncil", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Farmer> farmers;

    @OneToMany(mappedBy = "unionCouncil", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FarmerWaterReport> farmerWaterReports;

    @OneToMany(mappedBy = "unionCouncil", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Terrain> terrains;

}
