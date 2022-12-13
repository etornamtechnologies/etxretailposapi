package com.etx.engineering.PosService.domain.dto;


import com.etx.engineering.PosService.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO<T> {
    public ResponseDTO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    private Integer code;
    private String message;
    private T data;

    @Data
    public static class CreateUserResponseDTO {
        private User user;
        private String generatedPassword;
    }


    @Data
    public static class LoginResponseDTO {
        private User user;
        private String jwtToken;
    }
}
