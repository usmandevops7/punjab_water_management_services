package com.punjab.water.management.water_management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "water_resource_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Water_resource_type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String water_resource_type_name;

    @Column(nullable = false)
    private String water_resource_type_name_ur;

    @OneToMany(mappedBy = "water_resource_type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Water_resource> water_resources;

}
