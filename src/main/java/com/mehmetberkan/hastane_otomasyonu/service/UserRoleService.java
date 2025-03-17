package com.mehmetberkan.hastane_otomasyonu.service;

import com.mehmetberkan.hastane_otomasyonu.entity.UserRole;
import com.mehmetberkan.hastane_otomasyonu.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public void addRole(String roleName, Long userId){
        userRoleRepository.save(UserRole.builder()
                .roleName(roleName)
                .userId(userId)
                .build());
    }

    public List<UserRole> findAllRole(Long userId){
        return userRoleRepository.findByUserId(userId);
    }
}
