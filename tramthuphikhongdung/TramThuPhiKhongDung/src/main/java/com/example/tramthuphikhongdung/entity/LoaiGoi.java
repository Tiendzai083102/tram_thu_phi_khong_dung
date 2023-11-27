package com.example.tramthuphikhongdung.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoaiGoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String loaive;
    @Column(nullable = false)
    private String loaixe;
    @Column(nullable = false)
    private Integer gia;
}
