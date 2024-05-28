package com.ltudm.daltudmlastver.repository;

import com.ltudm.daltudmlastver.dto.TinTucDTO;
import com.ltudm.daltudmlastver.entity.TinTucEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TinTucRepository extends JpaRepository<TinTucEntity, Long> {
    TinTucEntity findOneById(Long id);
    void deleteById(Long id);

    @Query("SELECT  t FROM TinTucEntity t WHERE t.tieuDe like %?1%")
    List<TinTucDTO> searchTinTuc(String tieuDe);

}
