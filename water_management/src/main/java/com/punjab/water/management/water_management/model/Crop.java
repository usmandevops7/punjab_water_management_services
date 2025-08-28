package com.punjab.water.management.water_management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "crop")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crop {

    @Id
    @Column(nullable = false)
    private String crop_id;

    @Column(nullable = false)
    private String crop_name;

    private String crop_type;

}
