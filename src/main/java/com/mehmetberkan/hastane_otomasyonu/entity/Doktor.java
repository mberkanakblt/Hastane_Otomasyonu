package com.mehmetberkan.hastane_otomasyonu.entity;

import com.mehmetberkan.hastane_otomasyonu.utility.Brans;
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
@Table(name = "tbldoktor")
public class Doktor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String adSoyad;
    int yas;
    Brans brans;
}
