package com.mehmetberkan.hastane_otomasyonu.controller;

import com.mehmetberkan.hastane_otomasyonu.dto.request.AddDoktorRequestDto;
import com.mehmetberkan.hastane_otomasyonu.dto.response.BaseResponse;
import com.mehmetberkan.hastane_otomasyonu.entity.Doktor;
import com.mehmetberkan.hastane_otomasyonu.service.DoktorService;
import com.mehmetberkan.hastane_otomasyonu.utility.Brans;
import com.mehmetberkan.hastane_otomasyonu.view.VwDoktorList;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mehmetberkan.hastane_otomasyonu.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(DOKTOR)
@CrossOrigin("*")
@SecurityRequirement(name = "bearerAuth")
public class DoktorController {
    private final DoktorService doktorService;

    @PostMapping(ADD_DOKTOR)
    public ResponseEntity<BaseResponse<Boolean>> addDoktor(@RequestBody AddDoktorRequestDto dto){
        doktorService.addDoctor(dto);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .code(200)
                        .message("Doktor eklendi")
                        .data(true)
                .build());
    }
    @GetMapping(GET_ALL_DOKTOR)
    public ResponseEntity<BaseResponse<List<VwDoktorList>>> getAllDoktor(){
        return ResponseEntity.ok(BaseResponse.<List<VwDoktorList>>builder()
                .code(200)
                .message("ÜRün Listesi getirildi.")
                .data(doktorService.getVwDoktorList())
                .build());
    }

    @GetMapping(FIND_DOKTOR+"/{doktorId}")
    public ResponseEntity<BaseResponse<Doktor>> findById(@PathVariable Long doktorId){
        return ResponseEntity.ok(BaseResponse.<Doktor>builder()
                        .code(200)
                        .message("Doktorun bilgileri getirildi")
                        .data(doktorService.findAllById(doktorId))

                .build());
    }

    @GetMapping(FIND_BY_DOKTOR_BRANS+"/{brans}")
    public ResponseEntity<BaseResponse<List<Doktor>>> findByBrans(@PathVariable Brans brans){
        return ResponseEntity.ok(BaseResponse.<List<Doktor>>builder()
                        .code(200)
                        .message("Bransa gore doktor listelendi")
                        .data(doktorService.findAllByBrans(brans))
                .build());
    }

}
