package com.jdroidcoder.service.serviceimpl;

import com.jdroidcoder.persistent.entity.UserEntity;
import com.jdroidcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by jdroidcoder on 24.01.17.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity user = userRepository.getUserByName(login);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", login));
        }
        return user;
    }
}