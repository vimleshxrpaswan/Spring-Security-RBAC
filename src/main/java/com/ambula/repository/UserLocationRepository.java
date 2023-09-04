package com.ambula.repository;

import com.ambula.entities.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {

    public Optional<UserLocation> findByUserId(String userId);

    public Optional<UserLocation> deleteByUserId(String userId);

}
