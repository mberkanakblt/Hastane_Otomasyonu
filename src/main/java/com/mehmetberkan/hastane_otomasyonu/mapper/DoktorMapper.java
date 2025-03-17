package com.mehmetberkan.hastane_otomasyonu.mapper;

import com.mehmetberkan.hastane_otomasyonu.dto.request.AddDoktorRequestDto;
import com.mehmetberkan.hastane_otomasyonu.entity.Doktor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface DoktorMapper {
    DoktorMapper INSTANCE = Mappers.getMapper(DoktorMapper.class);

    Doktor mapperDtoDoktor(AddDoktorRequestDto dto);
}
