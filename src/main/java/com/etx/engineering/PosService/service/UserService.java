package com.etx.engineering.PosService.service;

import com.etx.engineering.PosService.CommonHelper;
import com.etx.engineering.PosService.domain.dto.RequestDTO;
import com.etx.engineering.PosService.domain.dto.ResponseDTO;
import com.etx.engineering.PosService.domain.exceptions.DatabaseException;
import com.etx.engineering.PosService.domain.exceptions.NotFoundException;
import com.etx.engineering.PosService.domain.model.User;
import com.etx.engineering.PosService.repository.ActivityLogRepository;
import com.etx.engineering.PosService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private ActivityLogRepository activityLogRepository;

    public List<User> findAll() {
        try {
            return userRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        } catch (Exception e) {
            throw new DatabaseException();
        }
    }


    public User findByUsername(String username) {
        try {
            return userRepository.findByUsernameIgnoreCase(username).orElseThrow(() -> new NotFoundException("User not found by username"));
        } catch (Exception e) {
            throw new DatabaseException();
        }
    }

    public User findById(Long userId) {
        try {
            return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found by id"));
        } catch (Exception e) {
            throw new DatabaseException();
        }
    }


    public ResponseDTO.CreateUserResponseDTO save(RequestDTO.CreateUserDTO dto) {
        ResponseDTO.CreateUserResponseDTO response = new ResponseDTO.CreateUserResponseDTO();

        String generatedPassword = CommonHelper.generateRandomSecurePassword();

        try {
            User model = new User();
            model.setName(dto.getName());
            model.setUsername(dto.getUsername());
            model.setEmail(dto.getEmail());
            model.setPhone(dto.getPhone());
            model.setPassword(passwordEncoder.encode(generatedPassword));
            model.setEnabled(true);
            model.setIsDefaultPassword(true);

            User user = userRepository.save(model); //save user

            response.setUser(user);
            response.setGeneratedPassword(generatedPassword);
            return response;
        } catch (Exception e) {
            throw new DatabaseException("Failed to save user");
        }
    }

    public User update(Long userId, RequestDTO.CreateUserDTO dto) {
        ResponseDTO.CreateUserResponseDTO response = new ResponseDTO.CreateUserResponseDTO();

        try {
            User model = findById(userId);

            model.setName(dto.getName());
            model.setEmail(dto.getEmail());
            model.setPhone(dto.getPhone());
            model.setEnabled(true);

            return userRepository.save(model); //save user
        } catch (Exception e) {
            throw new DatabaseException("Failed to save user");
        }
    }

    public void deleteById(Long id) {
        try {
            User user = findById(id);

            userRepository.delete(user);

        } catch (Exception e) {
            throw new DatabaseException("Failed to delete this user!");
        }
    }
}
