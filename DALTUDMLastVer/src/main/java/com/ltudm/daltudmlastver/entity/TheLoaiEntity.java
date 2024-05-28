package com.ltudm.daltudmlastver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TheLoai")
public class TheLoaiEntity extends BaseEntity {

    @Column(name = "Code")
    private String code;

    @Column(name = "TheLoai")
    private String theLoai;

    @OneToMany(mappedBy = "theLoai")
    private List<TinTucEntity> Tintucs = new ArrayList<>();

    public String getCodeTheLoai() {
        return code;
    }

    public void setCodeTheLoai(String codeTheLoai) {
        this.code = codeTheLoai;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public List<TinTucEntity> getTintucs() {
        return Tintucs;
    }

    public void setTintucs(List<TinTucEntity> tintucs) {
        Tintucs = tintucs;
    }
}
