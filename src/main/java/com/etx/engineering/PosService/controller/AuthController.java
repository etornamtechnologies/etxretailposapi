package com.etx.engineering.PosService.controller;

import com.etx.engineering.PosService.domain.dto.RequestDTO;
import com.etx.engineering.PosService.domain.dto.ResponseDTO;
import com.etx.engineering.PosService.domain.model.User;
import com.etx.engineering.PosService.repository.UserRepository;
import com.etx.engineering.PosService.security.JWTUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
@Slf4j
public class AuthController {
    private final UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;
    @PostMapping("/login")
    public ResponseDTO<ResponseDTO.LoginResponseDTO> login(@RequestBody @Valid RequestDTO.LoginRequestDTO body) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword());

            authenticationManager.authenticate(authenticationToken);

            User user = userRepository.findByUsernameIgnoreCase(body.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Invalid password"));

            String jwtToken = jwtUtil.generateToken(body.getUsername());
            ResponseDTO.LoginResponseDTO data = new ResponseDTO.LoginResponseDTO();
            data.setUser(user);
            data.setJwtToken(jwtToken);

            return new ResponseDTO<>(0, "Login successful", data);
        } catch (Exception e) {
            return new ResponseDTO<>(404, "Username/Password incorrect");
        }
    }
}
