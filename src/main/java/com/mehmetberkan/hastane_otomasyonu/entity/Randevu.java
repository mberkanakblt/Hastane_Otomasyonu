package com.mehmetberkan.hastane_otomasyonu.entity;

import com.mehmetberkan.hastane_otomasyonu.utility.Brans;
import com.mehmetberkan.hastane_otomasyonu.utility.Durum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tblrandevu")
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    Brans brans;
    String doktor;
    String localDate;
    String localTime;
    Durum durum;


}
