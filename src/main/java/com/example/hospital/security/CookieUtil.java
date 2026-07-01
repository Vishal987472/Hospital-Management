package com.example.hospital.security;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class CookieUtil {

    public static final String ACCESS_COOKIE = "access_token";

    public void create(HttpServletResponse response, String token) {

        Cookie cookie = new Cookie(ACCESS_COOKIE, token);

        cookie.setHttpOnly(true);

        cookie.setSecure(false); // true in production (HTTPS)

        cookie.setPath("/");

        cookie.setMaxAge(60 * 60 * 24);

        response.addCookie(cookie);
    }

    public void clear(HttpServletResponse response){

        Cookie cookie = new Cookie(ACCESS_COOKIE, "");

        cookie.setHttpOnly(true);

        cookie.setSecure(false);

        cookie.setPath("/");

        cookie.setMaxAge(0);

        response.addCookie(cookie);

    }

}