package com.mehmetberkan.hastane_otomasyonu.repository;

import com.mehmetberkan.hastane_otomasyonu.entity.UserRole;
import com.mehmetberkan.hastane_otomasyonu.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUserId(Long id);
}
