package com.punjab.water.management.water_management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "recommended_crops_report")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recommended_crops_report {

    @Id
    @Column(nullable = false)
    private String rec_id;

    @Column(nullable = false)
    private String report_id;

    @Column(nullable = false)
    private String crop_id;

    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id")
    private Crop crop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id")
    private Farmer_water_report farmer_water_report;

}
