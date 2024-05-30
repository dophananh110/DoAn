package com.ltudm.daltudmlastver.controller;

import com.ltudm.daltudmlastver.entity.TinTucEntity;
import com.ltudm.daltudmlastver.service.TinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class TinTucController {

    @Autowired
    private TinTucService tinTucService;


    @PostMapping(value = "/tintuc/DangBai")
    public void createTinTuc(@RequestBody TinTucEntity model) {
        tinTucService.createTinTuc(model);
    }


    @PutMapping(value = "/tintuc/{id}")
    public void updateTinTuc(@RequestBody TinTucEntity model, @PathVariable("id") Long id) {
        model.setId(id);
        tinTucService.updateTinTuc(id, model);
    }


    @DeleteMapping(value = "/tintuc/{id}")
    public void deleteTinTuc(@PathVariable("id") Long id) {
        tinTucService.deleteTinTuc(id);
    }

    @GetMapping(value = "/tintuc/list/{codeType}")
    public ResponseEntity<List<?>> getTinTucByType(@PathVariable("codeType") String codeType) {
        return ResponseEntity.status(HttpStatus.OK).body(tinTucService.findByType(codeType));
    }

    @GetMapping("/tintuc/searchbyTieuDe")
    public ResponseEntity<List<TinTucEntity>> findTinTucByTieuDe(@RequestParam("tieuDe") String tieuDe) {
        List<TinTucEntity> tinTucList = tinTucService.findByTieuDe(tieuDe);
        if (tinTucList != null) {
            return new ResponseEntity<List<TinTucEntity>>(tinTucList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
