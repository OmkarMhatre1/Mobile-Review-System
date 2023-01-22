package APIGATEWAY.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private String userId;
    private String accessToken;
    private String refreshToken;
    private Long expireAt;
    private Collection<String> authorities;



}
