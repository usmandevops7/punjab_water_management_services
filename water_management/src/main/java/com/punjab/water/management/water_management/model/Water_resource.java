package com.punjab.water.management.water_management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.databind.JsonNode;

@Entity
@Table(name = "water_resource")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Water_resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String water_resource_name;

    @Column(nullable = false)
    private String water_resource_name_ur;

    @Column(nullable = false)
    private Integer water_resource_type_id;

    private String water_course;

    private Integer total_length;

    private String coordinates;

    private String water_quality;

    private Integer senction_discharge;

    private Integer design_discharge;

    private Integer gca;

    private Integer cca;

    private JsonNode meta_data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "water_resource_type_id")
    private Water_resource_type water_resource_type;

}
