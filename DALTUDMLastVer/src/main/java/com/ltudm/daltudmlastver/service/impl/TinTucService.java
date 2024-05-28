package com.ltudm.daltudmlastver.service.impl;

import com.ltudm.daltudmlastver.converter.TinTucConverter;
import com.ltudm.daltudmlastver.dto.TinTucDTO;
import com.ltudm.daltudmlastver.entity.TheLoaiEntity;
import com.ltudm.daltudmlastver.entity.TinTucEntity;
import com.ltudm.daltudmlastver.repository.TheLoaiRepository;
import com.ltudm.daltudmlastver.repository.TinTucRepository;
import com.ltudm.daltudmlastver.service.ITinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TinTucService implements ITinTucService {

    @Autowired
    private TinTucRepository tinTucRepository;

    @Autowired
    private TheLoaiRepository theLoaiRepository;

    @Autowired
    private TinTucConverter tinTucConverter;

    @Override
    public TinTucDTO save(TinTucDTO tinTucDTO) {
        TinTucEntity tinTucEntity = new TinTucEntity();
        if (tinTucDTO.getId() != null) {
            TinTucEntity oldTinTucEntity = tinTucRepository.findOneById(tinTucDTO.getId());
            tinTucEntity = tinTucConverter.toEntity(tinTucDTO, oldTinTucEntity);
        } else {
            tinTucEntity = tinTucConverter.toEntity(tinTucDTO);
        }
        TheLoaiEntity theLoaiEntity = theLoaiRepository.findOneByCode(tinTucDTO.getCodeTheLoai());
        tinTucEntity.setTheLoai(theLoaiEntity);
        tinTucEntity = tinTucRepository.save(tinTucEntity);
        return tinTucConverter.toDTO(tinTucEntity);
    }

//    @Override
//    public TinTucDTO update(TinTucDTO tinTucDTO) {
//        TinTucEntity oldTinTucEntity = tinTucRepository.findOne(tinTucDTO.getId());
//        TinTucEntity tinTucEntity = tinTucConverter.toEntity(tinTucDTO, oldTinTucEntity);
//        TheLoaiEntity theLoaiEntity = theLoaiRepository.findOneByCode(tinTucDTO.getCodeTheLoai());
//        tinTucEntity.setTheLoai(theLoaiEntity);
//        tinTucEntity = tinTucRepository.save(tinTucEntity);
//        return null;
//    }


    @Override
    public void delete(Long[] ids) {
        for (Long item : ids) {
            tinTucRepository.deleteById(item);
        }
    }

    @Override
    public List<TinTucDTO> findAll(Pageable pageable) {
        List<TinTucDTO> results = new ArrayList<TinTucDTO>();
        List<TinTucEntity> entities = tinTucRepository.findAll(pageable).getContent();
        for (TinTucEntity item : entities) {
            TinTucDTO tinTucDTO = tinTucConverter.toDTO(item);
            results.add(tinTucDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) tinTucRepository.count();
    }

}
