package com.ltudm.daltudmlastver.service.impl;
import com.ltudm.daltudmlastver.entity.TheLoaiEntity;
import com.ltudm.daltudmlastver.entity.TinTucEntity;
import com.ltudm.daltudmlastver.repository.TheLoaiRepository;
import com.ltudm.daltudmlastver.repository.TinTucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ITinTucService implements com.ltudm.daltudmlastver.service.TinTucService {



    @Autowired
    private TinTucRepository tinTucRepository;

    @Autowired
    private TheLoaiRepository theLoaiRepository;

    @Override
    public void createTinTuc(TinTucEntity tinTucEntity) {
        tinTucRepository.save(tinTucEntity);
    }

    @Override
    public void updateTinTuc(Long id, TinTucEntity tinTucEntity) {
        tinTucEntity.setId(id);
        tinTucRepository.save(tinTucEntity);
    }

    @Override
    public void deleteTinTuc(Long id) {
            tinTucRepository.deleteById(id);
    }

    @Override
    public List<TinTucEntity> findAll(Pageable pageable) {
        List<TinTucEntity> entities = tinTucRepository.findAll(pageable).getContent();
        return entities;
    }

    @Override
    public TinTucEntity getTinTucById(Long id) {
        Optional<TinTucEntity> optionalEntity = tinTucRepository.findById(id);
        return optionalEntity.orElse(null);
    }


    @Override
    public List<TinTucEntity> findByTieuDe(String tieuDe) {
        List<TinTucEntity> list = tinTucRepository.findByTieuDe(tieuDe);
        return list;
    }

    @Override
    public List<TinTucEntity> getAllTinTuc() {
        return List.of();
    }


    @Override
    public List<TinTucEntity> findByType(String codeType) {
        TheLoaiEntity theLoai = theLoaiRepository.findByCode(codeType);

        List<TinTucEntity> list = tinTucRepository.findByTheLoaiId(theLoai.getId());
        return list;
    }
}
