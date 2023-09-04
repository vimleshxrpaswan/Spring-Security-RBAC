package com.ambula.service;

import com.ambula.dto.UserCredentials;
import com.ambula.entities.UserEntity;

public interface UserService {
    public String registerUser(UserEntity userEntity);
    public String login(UserCredentials userCredentials);
}
