package com.mehmetberkan.hastane_otomasyonu.repository;

import com.mehmetberkan.hastane_otomasyonu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findOptionalByEmailAndPassword(String email, String password);

    Optional<User> findById(Long userId);
}
