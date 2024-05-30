package com.ltudm.daltudmlastver.service;
import com.ltudm.daltudmlastver.entity.TinTucEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TinTucService {
    List<TinTucEntity> findByType(String codeType);

    void createTinTuc(TinTucEntity tinTucEntity);

    void updateTinTuc(Long id, TinTucEntity tinTucEntity);

    void deleteTinTuc(Long id);

    List<TinTucEntity> findAll(Pageable pageable);

    TinTucEntity getTinTucById(Long id);

    List<TinTucEntity> findByTieuDe (String tieuDe);

    List<TinTucEntity> getAllTinTuc();
}
