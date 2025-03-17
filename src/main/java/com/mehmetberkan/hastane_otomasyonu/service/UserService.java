package com.mehmetberkan.hastane_otomasyonu.service;

import com.mehmetberkan.hastane_otomasyonu.dto.request.DoLoginRequestDto;
import com.mehmetberkan.hastane_otomasyonu.dto.request.DoRegisterRequestDto;
import com.mehmetberkan.hastane_otomasyonu.entity.User;
import com.mehmetberkan.hastane_otomasyonu.mapper.UserMapper;
import com.mehmetberkan.hastane_otomasyonu.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByUserId(Long userId) {
        return userRepository.findById(userId);
    }

    public void doRegister(@Valid DoRegisterRequestDto dto) {
        User user = UserMapper.INSTANCE.mapperDtoUser(dto);
        userRepository.save(user);
    }

    public Optional<User> findByEmailPassword(@Valid DoLoginRequestDto dto) {
        return userRepository.findOptionalByEmailAndPassword(dto.email(),dto.password());
    }

}
