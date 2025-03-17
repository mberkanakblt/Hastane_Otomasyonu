package com.mehmetberkan.hastane_otomasyonu.controller;

import com.mehmetberkan.hastane_otomasyonu.config.JwtManager;
import com.mehmetberkan.hastane_otomasyonu.dto.request.AddRandevuRequestDto;
import com.mehmetberkan.hastane_otomasyonu.dto.response.BaseResponse;
import com.mehmetberkan.hastane_otomasyonu.entity.Randevu;
import com.mehmetberkan.hastane_otomasyonu.exception.ErrorType;
import com.mehmetberkan.hastane_otomasyonu.exception.HastaneException;
import com.mehmetberkan.hastane_otomasyonu.service.RandevuService;
import com.mehmetberkan.hastane_otomasyonu.view.VwRandevuList;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.mehmetberkan.hastane_otomasyonu.config.RestApis.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(RANDEVU)
@CrossOrigin("*")
@SecurityRequirement(name = "bearerAuth")
public class RandevuController {

    private final RandevuService randevuService;
    private final JwtManager jwtManager;

    @PostMapping(ADD_RANDEVU)
    public ResponseEntity<BaseResponse<Boolean>> addRandevu(@RequestBody AddRandevuRequestDto dto) {
        randevuService.addRandevu(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .code(200)
                        .message("Randevunuz olusturuldu")
                .data(true)
                .build());
    }
    @GetMapping(FIND_RANDEVU)
    public ResponseEntity<BaseResponse<List<VwRandevuList>>> finddRandevuById(@PathVariable Long userId) {

        return ResponseEntity.ok(BaseResponse.<List<VwRandevuList>>builder()
                        .code(200)
                        .message("Randevularınız...")
                        .data(randevuService.findAllById(userId))

                .build());
    }
    @DeleteMapping(CANCEL_RANDEVU)
    public ResponseEntity<BaseResponse<Boolean>> cancelRandevu(@PathVariable Long randevuId){
        randevuService.cancelRandevu(randevuId);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                .code(200)
                .message("Randevunuz iptal edildi")
                .data(true)
                .build());
    }



}
