package com.mehmetberkan.hastane_otomasyonu.view;

import com.mehmetberkan.hastane_otomasyonu.utility.Brans;
import com.mehmetberkan.hastane_otomasyonu.utility.Durum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VwRandevuList {
    Brans brans;
    String doktor;
    String localDate;
    String localTime;
    Durum durum;

}
