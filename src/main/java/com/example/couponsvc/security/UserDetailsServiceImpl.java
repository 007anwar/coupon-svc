package com.example.couponsvc.security;

import com.example.couponsvc.entity.User;
import com.example.couponsvc.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepo userRepo;

    @Autowired
    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byEmail = userRepo.findByEmail(username);
        if(byEmail==null)
        {
            throw new UsernameNotFoundException("invalid username "+username);
        }
        else {
        return new org.springframework.security.core.userdetails.User(byEmail.getEmail(),byEmail.getPassword(),byEmail.getRoles());
    }}
}
