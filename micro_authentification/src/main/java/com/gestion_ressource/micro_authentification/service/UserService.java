package com.gestion_ressource.micro_authentification.service;

import com.gestion_ressource.micro_authentification.model.User;
import com.gestion_ressource.micro_authentification.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findFirstByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("No Existing User With This Username: {}", s)));

        return UserAuth.getFromUser(user);
    }
}
