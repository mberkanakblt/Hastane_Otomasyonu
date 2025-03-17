package com.mehmetberkan.hastane_otomasyonu.controller;

import com.mehmetberkan.hastane_otomasyonu.config.JwtManager;
import com.mehmetberkan.hastane_otomasyonu.dto.request.AddRoleRequestDto;
import com.mehmetberkan.hastane_otomasyonu.dto.request.DoLoginRequestDto;
import com.mehmetberkan.hastane_otomasyonu.dto.request.DoRegisterRequestDto;
import com.mehmetberkan.hastane_otomasyonu.dto.response.BaseResponse;
import com.mehmetberkan.hastane_otomasyonu.entity.User;
import com.mehmetberkan.hastane_otomasyonu.exception.ErrorType;
import com.mehmetberkan.hastane_otomasyonu.exception.HastaneException;
import com.mehmetberkan.hastane_otomasyonu.service.UserRoleService;
import com.mehmetberkan.hastane_otomasyonu.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.mehmetberkan.hastane_otomasyonu.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER)
@CrossOrigin("*")
@SecurityRequirement(name = "bearerAuth")
public class UserController {
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final JwtManager jwtManager;

    @PostMapping(DOREGISTER)
    public ResponseEntity<BaseResponse<Boolean>> doRegister(@RequestBody @Valid DoRegisterRequestDto dto) {
        if(!dto.password().equals(dto.repassword()))
            throw new HastaneException(ErrorType.SIFREHATASI);
        userService.doRegister(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .code(200)
                        .message("Kayit basarili")
                        .data(true)
                .build());
    }
    @PostMapping(LOGIN)
    public ResponseEntity<BaseResponse<String>> doLogin(@RequestBody @Valid DoLoginRequestDto dto){
        Optional<User> optionalKullanici = userService.findByEmailPassword(dto);
        if(optionalKullanici.isEmpty())
            throw  new HastaneException(ErrorType.EMAIL_SIFRE_HATASI);
        return ResponseEntity.ok(BaseResponse.<String>builder()
                        .code(200)
                        .message("Giris Basarili")
                        .data(jwtManager.createToken(optionalKullanici.get().getId()))
                .build());
    }
    @PostMapping(ADD_ROLE)
    public ResponseEntity<BaseResponse<Boolean>> addRole(@RequestBody AddRoleRequestDto dto){
        userRoleService.addRole(dto.roleName(), dto.userId());
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .code(200)
                        .message("Role eklendi")
                        .data(true)
                .build());

    }

}
