package com.mehmetberkan.hastane_otomasyonu.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DoLoginRequestDto(
        @NotNull
        @NotEmpty
        String email,
        @NotNull
        @NotEmpty
        String password
) {
}
