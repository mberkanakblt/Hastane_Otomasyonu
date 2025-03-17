package com.mehmetberkan.hastane_otomasyonu.repository;

import com.mehmetberkan.hastane_otomasyonu.entity.Randevu;
import com.mehmetberkan.hastane_otomasyonu.view.VwRandevuList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RandevuRepository extends JpaRepository<Randevu, Integer> {


    Optional<Randevu> findById(Long randevuId);

    List<VwRandevuList> findAllById(Long userId);
}
