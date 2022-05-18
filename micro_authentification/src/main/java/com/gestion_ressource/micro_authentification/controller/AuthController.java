package com.gestion_ressource.micro_authentification.controller;

import com.gestion_ressource.micro_authentification.helper.JwtHelper;
import com.gestion_ressource.micro_authentification.model.*;
import com.gestion_ressource.micro_authentification.repository.RoleRepository;
import com.gestion_ressource.micro_authentification.repository.UserRepository;
import com.gestion_ressource.micro_authentification.service.UserAuth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtHelper jwtHelper;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody Login loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtHelper.generateJwtToken(authentication);

        UserAuth userDetails = (UserAuth) authentication.getPrincipal();

//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList()
//        );
        log.info("login");

        return new ResponseEntity<JwtResponse>(new JwtResponse(
                jwt,
                userRepository.findById(userDetails.getId()).orElseThrow()
        ),
                HttpStatus.OK
        );
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {

        System.err.println(registerRequest.getRoles());

        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            return new ResponseEntity<String>("Error: Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            return new ResponseEntity<String>("Error: Email is already taken!!", HttpStatus.BAD_REQUEST);
        }

        // Create new user's account
        User user = new User(registerRequest.getUsername(),
                registerRequest.getEmail(),
                encoder.encode(registerRequest.getPassword())
        );

        Set<String> strRoles = registerRequest.getRoles();

        String address = registerRequest.getAddress();

        String phone = registerRequest.getPhone();

        String name = registerRequest.getName();

        String laboratoire = registerRequest.getLaboratoire();

        String department = registerRequest.getDepartment();




        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            return new ResponseEntity<String>("Error: You should have at least one role!", HttpStatus.BAD_REQUEST);
        }

        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                    break;
                case "prof":

                    Role modRole = roleRepository.findByName(ERole.ROLE_PROF)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(modRole);
                    break;

                case "chef_departement":
                    Role chefDep = roleRepository.findByName(ERole.ROLE_CHEF_DEP)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(chefDep);
                    break;
                case "chef_resources":
                    Role chef_resources = roleRepository.findByName(ERole.ROLE_CHEF_RESOURCES)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(chef_resources);
                    break;
                case "provider":
                    Role provider = roleRepository.findByName(ERole.ROLE_PROVIDER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(provider);
                    break;
                case "administrative":
                    Role administrative = roleRepository.findByName(ERole.ROLE_ADMINISTRATIVE)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(administrative);
                    break;
                case "respo_mainte":
                    Role respo_mainte = roleRepository.findByName(ERole.ROLE_Respo_Maint)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(respo_mainte);
                    break;
            }
        });

        user.setAuthorities(roles);
        user.setAddress(address);
        user.setPhone(phone);
        user.setName(name);
        user.setDepartment(department);
        user.setLaboratoire(laboratoire);
        userRepository.save(user);

        return new ResponseEntity<String>("Success: user regitered successfully!", HttpStatus.OK);
    }
}
