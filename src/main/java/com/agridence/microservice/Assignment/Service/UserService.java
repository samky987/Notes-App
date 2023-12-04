package com.agridence.microservice.Assignment.Service;

import com.agridence.microservice.Assignment.DTO.SessionDTO;
import com.agridence.microservice.Assignment.DTO.SignupDTO;
import com.agridence.microservice.Assignment.Model.User;
import com.agridence.microservice.Assignment.Repository.UserRepository;
import com.agridence.microservice.Assignment.Security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService
{
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder encoder;


    public String authenticateUser(SessionDTO sessionDTO)
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(sessionDTO.getUsername(), sessionDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        return jwt;
    }
    public String registerUser(SignupDTO signupDTO)
    {
        if (userRepository.existsByUsername(signupDTO.getUsername()))
        {
            return "Error: Username is already taken!";
        }

        User user = new User(signupDTO.getFullName(),signupDTO.getUsername(),
                encoder.encode(signupDTO.getPassword()));

        userRepository.save(user);
        return "Profile is created!";
    }
}
