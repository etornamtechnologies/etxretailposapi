package com.etx.engineering.PosService.domain.dto;

import com.etx.engineering.PosService.domain.enums.ProductType;
import lombok.Data;

import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

public class RequestDTO {

    @Data
    public static class CreateUserDTO {
        private String name;
        private String username;
        private String email;
        private String phone;
        private Long roleId;
    }


    @Data
    public static class LoginRequestDTO {
        @NotNull(message = "Username required")
        private String username;
        @NotNull(message = "Password required")
        private String password;
    }

    @Data
    public static class CreateProductCategoryRequestDTO {
        private String name;
        private String description;
        private ProductType productType;
    }
}
