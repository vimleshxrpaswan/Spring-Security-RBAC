package com.ambula.configs;

import com.ambula.entities.UserEntity;
import com.ambula.repository.UserEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserEntityRepository  userEntityRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userEntityRepository.findByName(username);
        CurrentUserEntity currentUserEntity = new CurrentUserEntity();
        currentUserEntity.setUserPassword(userEntity.get().getUserPassword());
        currentUserEntity.setName(userEntity.get().getName());
        currentUserEntity.setRoles(userEntity.get().getRoles());
        return currentUserEntity;
    }

}
