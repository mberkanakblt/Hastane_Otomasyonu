package com.mehmetberkan.hastane_otomasyonu.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AddRoleRequestDto(
        @NotNull
        @NotEmpty
        Long userId,
        String roleName
) {
}
