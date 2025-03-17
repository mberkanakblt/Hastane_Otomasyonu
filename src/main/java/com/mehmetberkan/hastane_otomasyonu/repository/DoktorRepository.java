package com.mehmetberkan.hastane_otomasyonu.repository;

import com.mehmetberkan.hastane_otomasyonu.entity.Doktor;
import com.mehmetberkan.hastane_otomasyonu.utility.Brans;
import com.mehmetberkan.hastane_otomasyonu.view.VwDoktorList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoktorRepository extends JpaRepository<Doktor, Long> {
    @Query("select new com.mehmetberkan.hastane_otomasyonu.view.VwDoktorList(d.adSoyad,d.yas,d.brans) from Doktor d")
    List<VwDoktorList> getAllDoktorList();

    List<Doktor> findByBrans(Brans brans);
}
