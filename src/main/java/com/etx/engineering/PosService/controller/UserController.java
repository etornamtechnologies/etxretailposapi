package com.etx.engineering.PosService.controller;

import com.etx.engineering.PosService.domain.dto.RequestDTO;
import com.etx.engineering.PosService.domain.dto.ResponseDTO;
import com.etx.engineering.PosService.domain.model.User;
import com.etx.engineering.PosService.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @PostMapping
    public ResponseDTO<ResponseDTO.CreateUserResponseDTO> saveUser(@RequestBody @Valid RequestDTO.CreateUserDTO body,
                                                                   Principal principal) {
        log.info("=========CREATE USER CONTROLLER========");
        log.info("Create User Request: " + body.toString());

        ResponseDTO.CreateUserResponseDTO responseDTO = userService.save(body);

        return new ResponseDTO<>(0, "user created successfully", responseDTO);
    }

    @PutMapping("/{userId}")
    public ResponseDTO<User> editUser(@PathVariable(name = "userId") long userId,
                                      @RequestBody RequestDTO.CreateUserDTO body) {
        return new ResponseDTO<>(0, "User updated successfully", userService.update(userId, body));
    }

    @GetMapping
    public ResponseDTO<List<User>> getAll() {
        return new ResponseDTO<>(0, "Success", userService.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseDTO<User> getById(@PathVariable(name = "userId") Long userId) {
        return new ResponseDTO<>(0, "Success", userService.findById(userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseDTO deleteById(@PathVariable(name = "userId") Long userId) {
        userService.deleteById(userId);
        return new ResponseDTO(0, "User deleted successfully", null);
    }
}
