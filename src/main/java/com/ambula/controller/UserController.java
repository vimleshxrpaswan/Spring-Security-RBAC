package com.ambula.controller;

import com.ambula.entities.UserLocation;
import com.ambula.service.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@RestController
@RequestMapping("/ambula/")
public class UserController {

    @Autowired
    private UserLocationService userLocationService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create-data")
    public String createData(@RequestBody UserLocation userLocation) {
        return userLocationService.createData(userLocation);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update-data/{id}")
    public UserLocation updateData(@RequestBody UserLocation updatedUserLocation) {
        return userLocationService.updateData(updatedUserLocation);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_READER')")
    @GetMapping("/get-users/{count}")
    public List<UserLocation> getNearestUsers(@PathVariable int count) {
        return userLocationService.getNearestUsers(count);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete-user/{user_id}")
    public String deleteUser(@PathVariable("user_id") String userId) {
        return userLocationService.deleteUser(userId);
    }
}
