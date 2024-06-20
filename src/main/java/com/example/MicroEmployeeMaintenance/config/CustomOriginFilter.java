package com.example.MicroEmployeeMaintenance.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CustomOriginFilter extends OncePerRequestFilter {

    private static final String ALLOWED_ORIGIN = "http://localhost:4200";
    private static final String ALLOWED_PATH_PREFIX = "/user";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String origin = request.getHeader("Origin");
        String referer = request.getHeader("Referer");
        String requestURI = request.getRequestURI();

        boolean isAllowedPath = requestURI != null && requestURI.startsWith(ALLOWED_PATH_PREFIX);

        if ((origin != null && origin.equals(ALLOWED_ORIGIN)) ||
                (referer != null && referer.startsWith(ALLOWED_ORIGIN)) ||
                isAllowedPath) {
            filterChain.doFilter(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
        }
    }
}
