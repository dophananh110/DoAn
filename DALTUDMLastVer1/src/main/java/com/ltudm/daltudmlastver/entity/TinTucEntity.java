package com.ltudm.daltudmlastver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TinTuc")
public class TinTucEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TieuDe")
    private String tieuDe;

    @Column(name = "Thumbnail")
    private String thumbnail;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "NoiDung")
    private String noiDung;

    @ManyToOne
    @JoinColumn(name = "the_loai_id")
    private TheLoaiEntity theLoai;

}
