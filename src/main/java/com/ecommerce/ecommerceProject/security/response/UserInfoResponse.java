package com.ecommerce.ecommerceProject.security.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponse {
    private Long Id;
    private String jwtToken;
    private String username;
    private List<String> roles;
}
