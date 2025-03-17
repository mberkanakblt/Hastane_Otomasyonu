package com.mehmetberkan.hastane_otomasyonu.service;

import com.mehmetberkan.hastane_otomasyonu.dto.request.AddRandevuRequestDto;
import com.mehmetberkan.hastane_otomasyonu.entity.Randevu;
import com.mehmetberkan.hastane_otomasyonu.utility.Durum;
import com.mehmetberkan.hastane_otomasyonu.exception.ErrorType;
import com.mehmetberkan.hastane_otomasyonu.exception.HastaneException;
import com.mehmetberkan.hastane_otomasyonu.mapper.RandevuMapper;
import com.mehmetberkan.hastane_otomasyonu.repository.RandevuRepository;
import com.mehmetberkan.hastane_otomasyonu.view.VwRandevuList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RandevuService {
    private final RandevuRepository repository;
    public void addRandevu(AddRandevuRequestDto dto) {
        Randevu randevu = RandevuMapper.INSTANCE.mapperDtoRandevu(dto);
        repository.save(randevu);
    }

//    public List<VwRandevuList> getVwRandevuList(Long userId) {
//        return repository.getAllUrunListById(userId);
//    }

    public void cancelRandevu(Long randevuId) {
        Optional<Randevu> randevuOptional = repository.findById(randevuId);
        if(randevuOptional.isEmpty()) throw new HastaneException(ErrorType.RANDEVU_NOTFOUND);
        Randevu randevu = randevuOptional.get();
        randevu.setDurum(Durum.IPTAL);
        repository.save(randevu);
    }

    public List<VwRandevuList> findAllById(Long userId) {
        return repository.findAllById(userId);
    }
}
