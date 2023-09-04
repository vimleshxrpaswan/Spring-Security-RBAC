package com.ambula.repository;

import com.ambula.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity , Long> {
    public Optional<UserEntity> findByName(String name);

}
