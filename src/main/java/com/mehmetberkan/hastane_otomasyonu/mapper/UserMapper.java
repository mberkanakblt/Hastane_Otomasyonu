package com.mehmetberkan.hastane_otomasyonu.mapper;


import com.mehmetberkan.hastane_otomasyonu.dto.request.DoRegisterRequestDto;
import com.mehmetberkan.hastane_otomasyonu.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapperDtoUser(DoRegisterRequestDto dto);
}
