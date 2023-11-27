package com.example.tramthuphikhongdung.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuaTram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Date thoigian;
    @ManyToOne(targetEntity = Goi.class)
    private Goi goi;
    @ManyToOne(targetEntity = User.class)
    private User user;
}
