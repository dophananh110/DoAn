package com.ltudm.daltudmlastver.service;

import com.ltudm.daltudmlastver.dto.TinTucDTO;
import com.ltudm.daltudmlastver.entity.TinTucEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITinTucService {
    TinTucDTO save(TinTucDTO tinTucDTO);
//    TinTucDTO update(TinTucDTO tinTucDTO);

    void delete(Long[] ids);

    List<TinTucDTO> findAll(Pageable pageable);
    int totalItem();

}
