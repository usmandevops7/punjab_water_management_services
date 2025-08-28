package com.punjab.water.management.water_management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tehsil")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tehsil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long tehsil_id;

    @Column(nullable = false)
    private String tehsil_name;

    @Column(nullable = false)
    private Integer district_id;

    private String tehsil_name_ur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private District district;

    @OneToMany(mappedBy = "tehsil", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UnionCouncil> union_councils;

}
