package com.carrental.carrental2.services;

import com.carrental.carrental2.model.AppUser;
import com.carrental.carrental2.model.Role;
import com.carrental.carrental2.repository.AppUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final AppUserRepository repo;
    private final PasswordEncoder encoder;
    public UserServiceImpl(AppUserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }
    public AppUser registerSuperAdmin(String username, String rawPassword)
    {
        return createUser(username, rawPassword, Set.of(Role.SUPERADMIN));
    }

    public AppUser registerAdmin(String username, String rawPassword)
    {
        return createUser(username, rawPassword, Set.of(Role.ADMIN));
    }
    private AppUser createUser(String username, String rawPassword, Set<Role> roles)
    {
        if (repo.existsByUsername(username))
            throw new IllegalArgumentException("Username already exists");
        AppUser u = new AppUser();
        u.setUsername(username);
        u.setPassword(encoder.encode(rawPassword));
        u.setRoles(roles);
        return repo.save(u);
    }
}
