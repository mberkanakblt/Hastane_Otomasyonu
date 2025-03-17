package com.mehmetberkan.hastane_otomasyonu.dto.request;

import com.mehmetberkan.hastane_otomasyonu.utility.Brans;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AddDoktorRequestDto(
        @NotNull
        @NotEmpty
        @Size(min = 3, max = 30)
        String adSoyad,
        @Min(21)
        int yas,
        @NotNull
        @NotEmpty
        Brans brans
) {
}
