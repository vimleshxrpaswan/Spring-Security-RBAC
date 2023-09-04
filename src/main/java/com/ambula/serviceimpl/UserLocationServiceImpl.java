package com.ambula.serviceimpl;

import com.ambula.entities.UserLocation;
import com.ambula.exception.AmbulaCustomException;
import com.ambula.repository.UserLocationRepository;
import com.ambula.service.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserLocationServiceImpl implements UserLocationService {

    @Autowired
    private UserLocationRepository locationRepository;

    @Override
    public String createData(UserLocation userLocation) {
        Optional<UserLocation>  user = this.locationRepository.findByUserId(userLocation.getUserId());
        if(user.isPresent())
            throw new AmbulaCustomException("User already exists");
        String userId = UUID.randomUUID().toString();
        userLocation.setUserId(userId);
        System.out.println("User location::"+ userLocation);
        UserLocation save = this.locationRepository.save(userLocation);
        return "User Created Successfully"+save;

    }

    @Override
    public UserLocation updateData(UserLocation updatedUserLocation) {
        Optional<UserLocation> user = locationRepository.findByUserId(updatedUserLocation.getUserId());
        if(user.isEmpty())
            throw new AmbulaCustomException("User not found");
        return locationRepository.saveAndFlush(updatedUserLocation);
    }

    @Override
    public List<UserLocation> getNearestUsers(int count) {
        List<UserLocation> users = locationRepository.findAll();
        if(users.isEmpty())
            throw new AmbulaCustomException("Data not found");
        users.sort((user1, user2) -> {
            double distance1 = Math.sqrt(Math.pow(user1.getLatitude(), 2) + Math.pow(user1.getLongitude(), 2));
            double distance2 = Math.sqrt(Math.pow(user2.getLatitude(), 2) + Math.pow(user2.getLongitude(), 2));
            return Double.compare(distance1, distance2);
        });
        return users.subList(0, Math.min(count, users.size()));
    }

    @Override
    public String deleteUser(String userId) {
        Optional<UserLocation> user = this.locationRepository.findByUserId(userId);
        if(user.isEmpty())
            throw new AmbulaCustomException("User not found");
        locationRepository.deleteByUserId(userId);
        return "Data Deleted";
    }

}
