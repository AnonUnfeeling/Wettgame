package com.jdroidcoder.service.serviceimpl;

import com.jdroidcoder.persistent.entity.UserEntity;
import com.jdroidcoder.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jdroidcoder on 24.01.17.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserEntity getPrincipal() {
        return (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public List<String> getUserRoles() {
        List<String> roles = new ArrayList<>();
        SecurityContextHolder.getContext().getAuthentication().getAuthorities().forEach(authority -> roles.add(authority.getAuthority()));
        return roles;
    }

//    private String determineUrlByRoles(List<String> roles) {
//        logger.debug("determineUrlByRoles: " + roles);
//        if (roles.contains(Role.ADMIN.name())) {
//            return "/adminLogin";
//        }
//        if (roles.contains(Role.COMPANY.name())) {
//            return "/companyLogin";
//        }
//        if (roles.contains(Role.USER.name())) {
//            return "/userLogin";
//        }
//        return "/error";
//    }
}
