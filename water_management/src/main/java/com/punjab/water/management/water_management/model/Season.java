package com.punjab.water.management.water_management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "season")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer season_id;

    @Column(nullable = false)
    private String season_name;

    private String start_month;

    private String end_month;

}
