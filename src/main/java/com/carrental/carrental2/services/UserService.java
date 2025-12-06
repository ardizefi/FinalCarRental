package com.carrental.carrental2.services;

import com.carrental.carrental2.model.AppUser;

public interface UserService {
    AppUser registerAdmin(String username, String rawPassword);
    AppUser registerSuperAdmin(String username , String rawPassword);
}
