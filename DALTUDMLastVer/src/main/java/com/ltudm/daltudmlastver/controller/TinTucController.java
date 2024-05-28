package com.ltudm.daltudmlastver.controller;

import com.ltudm.daltudmlastver.controller.output.TinTucOutput;
import com.ltudm.daltudmlastver.dto.TinTucDTO;
import com.ltudm.daltudmlastver.service.ITinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@CrossOrigin
@RestController
public class TinTucController {

    @Autowired
    private ITinTucService tinTucService;

    @GetMapping(value = "/TinTuc")
    public TinTucOutput showTinTuc(@RequestParam("page") int page,
                                   @RequestParam("limit") int limit) {
        TinTucOutput result = new TinTucOutput();
        result.setPage(page);
        Pageable pageable = (Pageable) PageRequest.of(page, limit);
        result.setListResult(tinTucService.findAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (tinTucService.totalItem())/limit));
        return result;
    }

    @PostMapping(value = "/TinTuc")
    public TinTucDTO createTinTuc(@RequestBody TinTucDTO model) {
        return tinTucService.save(model);
    }

    @PutMapping(value = "/TinTuc/{id}")
    public TinTucDTO updateTinTuc(@RequestBody TinTucDTO model, @PathVariable("id") Long id) {
        model.setId(id);
        return tinTucService.save(model);
    }

    @DeleteMapping(value = "/TinTuc")
    public void deleteTinTuc(@RequestBody Long[] ids) {
        tinTucService.delete(ids);
    }




}
