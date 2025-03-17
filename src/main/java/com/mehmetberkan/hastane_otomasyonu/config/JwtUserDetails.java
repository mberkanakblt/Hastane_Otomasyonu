package com.mehmetberkan.hastane_otomasyonu.config;

import com.mehmetberkan.hastane_otomasyonu.entity.User;
import com.mehmetberkan.hastane_otomasyonu.entity.UserRole;
import com.mehmetberkan.hastane_otomasyonu.service.UserService;
import com.mehmetberkan.hastane_otomasyonu.service.UserRoleService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtUserDetails implements UserDetailsService {
    private final UserService userService;
    private final UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
    public UserDetails loadUserById(Long userId) {

        Optional<User> kullanici = userService.findByUserId(userId);
        if(kullanici.isEmpty()) return null;
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<UserRole> roleLists = userRoleService.findAllRole(userId);
        roleLists.forEach(r->{
            grantedAuthorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });

        return org.springframework.security.core.userdetails.User.builder()
                .username(kullanici.get().getEmail())
                .password(kullanici.get().getPassword())
                .accountLocked(false)
                .accountExpired(false)
                .authorities(grantedAuthorities)
                .build();
    }
}
