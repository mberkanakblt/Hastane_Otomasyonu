package com.mehmetberkan.hastane_otomasyonu.mapper;

import com.mehmetberkan.hastane_otomasyonu.dto.request.AddRandevuRequestDto;
import com.mehmetberkan.hastane_otomasyonu.entity.Randevu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface RandevuMapper {
    RandevuMapper INSTANCE = Mappers.getMapper(RandevuMapper.class);

    Randevu mapperDtoRandevu(AddRandevuRequestDto addRandevuRequestDto);
}
