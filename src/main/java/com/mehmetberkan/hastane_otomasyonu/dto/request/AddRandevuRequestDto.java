package com.mehmetberkan.hastane_otomasyonu.dto.request;

import com.mehmetberkan.hastane_otomasyonu.utility.Brans;
import com.mehmetberkan.hastane_otomasyonu.utility.Durum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AddRandevuRequestDto(
        Long userId,
        @NotNull
        @NotEmpty
        Brans brans,
        @NotNull
        @NotEmpty
        String doktor,
        @NotNull
        String localDate,
        @NotNull
        @NotEmpty
        String localTime,
        @NotNull
        @NotEmpty
        Durum durum
) {
}
