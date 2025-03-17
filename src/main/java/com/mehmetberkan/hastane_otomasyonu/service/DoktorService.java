package com.mehmetberkan.hastane_otomasyonu.service;

import com.mehmetberkan.hastane_otomasyonu.dto.request.AddDoktorRequestDto;
import com.mehmetberkan.hastane_otomasyonu.entity.Doktor;
import com.mehmetberkan.hastane_otomasyonu.mapper.DoktorMapper;
import com.mehmetberkan.hastane_otomasyonu.repository.DoktorRepository;
import com.mehmetberkan.hastane_otomasyonu.utility.Brans;
import com.mehmetberkan.hastane_otomasyonu.view.VwDoktorList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoktorService {
    private final DoktorRepository doktorRepository;

    public void addDoctor(AddDoktorRequestDto dto) {
        Doktor doktor = DoktorMapper.INSTANCE.mapperDtoDoktor(dto);
        doktorRepository.save(doktor);
    }

    public Doktor findAllById(Long doktorId) {
        return doktorRepository.findById(doktorId).orElse(null);
    }

    public List<VwDoktorList> getVwDoktorList() {
       return doktorRepository.getAllDoktorList();

    }

    public List<Doktor> findAllByBrans(Brans brans) {
       return  doktorRepository.findByBrans(brans);
    }
}
