package com.ltudm.daltudmlastver.controller.output;

import com.ltudm.daltudmlastver.dto.TinTucDTO;

import java.util.ArrayList;
import java.util.List;

public class TinTucOutput {

    private int page;
    private int totalPage;
    private List<TinTucDTO> listResult = new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<TinTucDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<TinTucDTO> listResult) {
        this.listResult = listResult;
    }
}
