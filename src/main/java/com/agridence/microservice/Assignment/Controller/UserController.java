package com.agridence.microservice.Assignment.Controller;

import com.agridence.microservice.Assignment.DTO.SessionDTO;
import com.agridence.microservice.Assignment.DTO.SignupDTO;
import com.agridence.microservice.Assignment.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;
    @PostMapping("/user/session")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody SessionDTO sessionDTO)
    {
        String jwt = userService.authenticateUser(sessionDTO);
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/user/")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupDTO signupDTO)
    {
        String message = userService.registerUser(signupDTO);
        return ResponseEntity.ok(message);
    }
}

