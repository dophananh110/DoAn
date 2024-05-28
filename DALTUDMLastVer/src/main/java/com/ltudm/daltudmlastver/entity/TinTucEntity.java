package com.ltudm.daltudmlastver.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TinTuc")
public class TinTucEntity extends BaseEntity {

    @Column(name = "TieuDe")
    private String tieuDe;

    @Column(name = "Thumbnail")
    private String Thumbnail;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "NoiDung")
    private String noiDung;

    @ManyToOne
    @JoinColumn(name = "TheLoai_id")
    private TheLoaiEntity theLoai;

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public TheLoaiEntity getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoaiEntity theLoai) {
        this.theLoai = theLoai;
    }

}
