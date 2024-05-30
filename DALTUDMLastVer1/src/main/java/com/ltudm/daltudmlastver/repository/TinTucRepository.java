package com.ltudm.daltudmlastver.repository;

import com.ltudm.daltudmlastver.entity.TinTucEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TinTucRepository extends JpaRepository<TinTucEntity, Long> {

    List<TinTucEntity> findByTheLoaiId(Long id);

    @Query("SELECT t FROM TinTucEntity t WHERE t.tieuDe LIKE %?1%")
    List<TinTucEntity> findByTieuDe(String tieuDe);
}
