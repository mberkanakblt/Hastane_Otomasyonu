package com.mehmetberkan.hastane_otomasyonu.dto.request;

import com.mehmetberkan.hastane_otomasyonu.utility.Gender;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DoRegisterRequestDto(
        @NotNull
        @NotEmpty
        @Size(min = 3, max = 30)
      String name,
        @NotNull
        @NotEmpty
        @Size(min = 3, max = 30)
      String surname,
        @NotNull
        @NotEmpty
      String email,
        @NotNull
        @NotEmpty
      String password,
        @NotNull
        @NotEmpty
      String repassword,
        @NotNull
        @NotEmpty
      String phone,
      String address,
        @NotNull
        @NotEmpty
      String tckn,
      String age,
      Gender gender
) {
}
