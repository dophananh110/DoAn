package com.ltudm.daltudmlastver.dto;

public class TinTucDTO extends BaseDTO<TinTucDTO> {

    private String tieuDe;
    private String noiDung;
    private String moTa;
    private String codeTheLoai;
    private String thumbnail;

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getCodeTheLoai() {
        return codeTheLoai;
    }

    public void setCodeTheLoai(String codeTheLoai) {
        this.codeTheLoai = codeTheLoai;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
