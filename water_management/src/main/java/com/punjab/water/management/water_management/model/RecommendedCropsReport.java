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
public class RecommendedCropsReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer rec_id;

    @Column(nullable = false)
    private Integer report_id;

    @Column(nullable = false)
    private Integer crop_id;

    private String reason;

    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id")
    private Crop crop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id")
    private FarmerWaterReport farmerWaterReport;

}
