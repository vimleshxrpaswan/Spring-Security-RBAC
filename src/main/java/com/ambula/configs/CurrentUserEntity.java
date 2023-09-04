package com.ambula.configs;

import com.ambula.entities.UserEntity;
import com.ambula.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class CurrentUserEntity implements UserDetails {
    public CurrentUserEntity(String name, String userPassword) {
        this.name = name;
        this.userPassword = userPassword;;
    }

    private Roles roles;
    private String name;

    private String userPassword;

    private List<GrantedAuthority> authorities= new ArrayList<>();

    public CurrentUserEntity(UserEntity userEntity) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.error("Inside userdetails : : "+this.roles.getValue());
        authorities.add(new SimpleGrantedAuthority(roles.getValue()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;

    }
}
