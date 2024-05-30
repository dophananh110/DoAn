package com.ltudm.daltudmlastver.repository;

import com.ltudm.daltudmlastver.entity.TheLoaiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheLoaiRepository extends JpaRepository<TheLoaiEntity, Long> {
    TheLoaiEntity findOneByCode(String code);

    TheLoaiEntity findByCode(String code);

}
