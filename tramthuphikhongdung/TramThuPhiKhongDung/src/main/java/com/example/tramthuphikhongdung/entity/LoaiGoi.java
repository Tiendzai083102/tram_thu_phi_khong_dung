package com.example.tramthuphikhongdung.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoaiGoi {
    @Id
    private String id;
    @Column(nullable = false)
    private String loaive;
    @Column(nullable = false)
    private String loaixe;
    @Column(nullable = false)
    private Integer gia;
}
