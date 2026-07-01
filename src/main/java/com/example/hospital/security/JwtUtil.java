package com.example.hospital.security;

import com.example.hospital.entity.provider.AuthProviderType;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *60))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

    }

    public String extractUsername(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);

        return username.equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }

    public AuthProviderType getProviderTypeFromRegistraionId(String registrationId) {
        return switch (registrationId.toLowerCase()) {
            case "google" -> AuthProviderType.GOOGLE;
            case "github" -> AuthProviderType.GITHUB;
            case "facebook" -> AuthProviderType.FACEBOOK;
            case "twitter" -> AuthProviderType.TWITTER;
            default -> throw new IllegalArgumentException(
                    "Unsupported auth provider: " + registrationId
            );
        };
    }

    public String determineProviderIdFromOAuth2User(
            OAuth2User oAuth2User,
            String registrationId
    ) {

        Map<String, Object> attributes = oAuth2User.getAttributes();

        String providerId = switch (registrationId.toLowerCase()) {
            case "google" -> (String) attributes.get("sub");
            case "github" -> String.valueOf(attributes.get("id"));
            case "facebook" -> (String) attributes.get("id");
            case "twitter" -> (String) attributes.get("id");
            default -> throw new IllegalArgumentException(
                    "Unsupported auth provider: " + registrationId
            );
        };

        if (providerId == null || providerId.isBlank()) {
            throw new IllegalArgumentException(
                    "Unable to determine provider ID for OAuth login"
            );
        }

        return providerId;
    }
    public String determineUsernameFromOAuth2User(
            OAuth2User oAuth2User,
            String registrationId,
            String providerId
    ) {

        Map<String, Object> attributes = oAuth2User.getAttributes();

        String email = (String) attributes.get("email");

        // ✅ Correct condition
        if (email != null && !email.isBlank()) {
            return email;
        }

        return switch (registrationId.toLowerCase()) {
            case "google" -> (String) attributes.get("sub");
            case "github" -> (String) attributes.get("login");
            case "facebook" -> (String) attributes.get("name");
            case "twitter" -> (String) attributes.get("username");
            default -> providerId;
        };
    }
}
