package com.ambula.service;

import com.ambula.entities.UserLocation;

import java.util.List;

public interface UserLocationService {

    public String createData(UserLocation userLocation);

    public UserLocation updateData (UserLocation updatedUserLocation);

    public List<UserLocation> getNearestUsers (int count);

    public String deleteUser (String userId);


}
