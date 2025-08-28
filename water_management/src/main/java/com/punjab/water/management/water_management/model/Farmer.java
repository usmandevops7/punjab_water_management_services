package com.punjab.water.management.water_management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "farmer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long farmer_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cnic;

    private String phone;

    private String address;

    @Column(nullable = false)
    private Integer uc_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uc_id")
    private Union_council union_council;

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Farmer_water_report> farmer_water_reports;

}
