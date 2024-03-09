package com.rtumirea.autoservice.service;

import com.rtumirea.autoservice.dao.entity.UserEntity;
import com.rtumirea.autoservice.dao.repository.UserRepository;
import com.rtumirea.autoservice.exception.AutoServiceException;
import com.rtumirea.autoservice.mapper.model.UserModelMapper;
import com.rtumirea.autoservice.model.UserModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserModelMapper userModelMapper;

    public UserModel getUser(String email){
        log.info("Getting user(email={})", email);
        Optional<UserEntity> optUser = userRepository.findUserByEmail(email);
        if (optUser.isPresent()){
            UserEntity userEntity = optUser.get();
            return userModelMapper.toModel(userEntity);
        } else {
            String message = String.format("Unable to find user(email=%s)", email);
            log.error(message);
            throw new AutoServiceException(message);
        }
    }

    @Override
    public UserEntity loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Getting user(email={}) for authentication", email);
        Optional<UserEntity> optUser = userRepository.findUserByEmail(email);
        if (optUser.isPresent()){
            return optUser.get();
        } else {
            String message = String.format("Unable to find user(email=%s)", email);
            log.error(message);
            throw new UsernameNotFoundException(message);
        }
    }
}
