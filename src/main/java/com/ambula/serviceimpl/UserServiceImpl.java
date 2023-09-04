package com.ambula.serviceimpl;

import com.ambula.dto.UserCredentials;
import com.ambula.entities.UserEntity;
import com.ambula.enums.Roles;
import com.ambula.repository.UserEntityRepository;
import com.ambula.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String registerUser(UserEntity userEntity) {
        userEntity.setUserPassword(passwordEncoder.encode(userEntity.getUserPassword()));
        if(userEntity.getRoles().getValue()=="ROLE_ ADMIN")
            userEntity.setRoles(Roles.ADMIN);
        else
            userEntity.setRoles(Roles.READER);
        userEntityRepository.save(userEntity);
        log.error(" REGISTER USER :: "+ userEntity.toString());
        return "User registered successfully!!";
    }

    @Override
    public String login(UserCredentials userCredentials) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userCredentials.getUsername(),userCredentials.getPassword()));
        if(authentication.isAuthenticated()) {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);
            return "logged in successfully!!";
        }
        else
            return "loggin failed";
    }
}
