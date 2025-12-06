package com.carrental.carrental2.controller;

import com.carrental.carrental2.dto.AppUserDTO;
import com.carrental.carrental2.model.AppUser;
import com.carrental.carrental2.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register-superadmin")
    public ResponseEntity<AppUser> registerSuperAdmin(@RequestBody AppUserDTO req) {
        return ResponseEntity.ok(userService.registerSuperAdmin(req.getUsername(), req.getPassword()));
    }

    @PreAuthorize("hasAnyRole('SUPERADMIN')")
    @PostMapping("/register-admin")
    public ResponseEntity<AppUser> registerAdmin(@RequestBody AppUserDTO req) {
        return ResponseEntity.ok(userService.registerAdmin(req.getUsername(), req.getPassword()));
    }
}
