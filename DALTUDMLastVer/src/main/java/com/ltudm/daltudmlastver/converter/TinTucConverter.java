package com.ltudm.daltudmlastver.converter;

import com.ltudm.daltudmlastver.dto.TinTucDTO;
import com.ltudm.daltudmlastver.entity.TinTucEntity;
import org.springframework.stereotype.Component;

@Component
public class TinTucConverter {
    public TinTucEntity toEntity(TinTucDTO dto) {
        TinTucEntity entity = new TinTucEntity();
        entity.setTieuDe(dto.getTieuDe());
        entity.setMoTa(dto.getMoTa());
        entity.setNoiDung(dto.getNoiDung());
        entity.setThumbnail(dto.getThumbnail());
        return entity;
    }

    public TinTucDTO toDTO(TinTucEntity entity) {
        TinTucDTO dto = new TinTucDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setTieuDe(entity.getTieuDe());
        dto.setMoTa(entity.getMoTa());
        dto.setNoiDung(entity.getNoiDung());
        dto.setThumbnail(dto.getThumbnail());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedBy(entity.getModifiedBy());
        return dto;
    }

    public TinTucEntity toEntity(TinTucDTO dto, TinTucEntity entity) {
        entity.setTieuDe(dto.getTieuDe());
        entity.setMoTa(dto.getMoTa());
        entity.setNoiDung(dto.getNoiDung());
        entity.setThumbnail(dto.getThumbnail());
        return entity;
    }

}
