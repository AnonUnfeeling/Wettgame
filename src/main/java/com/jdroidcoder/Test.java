package com.jdroidcoder;

import com.jdroidcoder.persistent.entity.LanguageEntity;
import com.jdroidcoder.persistent.entity.UserDataEntity;
import com.jdroidcoder.persistent.entity.UserEntity;
import com.jdroidcoder.persistent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jdroidcoder on 23.01.17.
 */
@RestController
public class Test {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/test")
    public void test() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("email12");
        userEntity.setActive(1);
        userEntity.setBlocked(0);
        userEntity.setPassword("dsa");
        userEntity.setUsername("user12");
        userEntity.setActivationCode("123a");
        UserDataEntity userDataEntity = new UserDataEntity();
        userDataEntity.setAboutMe("dsa");
//        userDataEntity.setLanguageEntity(new LanguageEntity("ENG",userDataEntity));
        userEntity.setUserData(userDataEntity);
        userRepository.save(userEntity);
    }
}
