package com.trade.authservice.AuditTrail;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class EndpointLoggingFilter extends OncePerRequestFilter {
    @Autowired
    private AuditTrailService auditTrailService;
    @Autowired
    public EndpointLoggingFilter(AuditTrailService auditTrailService){
        this.auditTrailService = auditTrailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String requestURL = request.getRequestURI();
            String method = request.getMethod();
            String remoteAddress = request.getRemoteAddr();

            // Check if user is authenticated (SecurityContextHolder)
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userEmail = null;
            if (authentication != null && authentication.isAuthenticated()) {
                userEmail = authentication.getName(); // Get username from authenticated user
                logger.debug("Retrieved user email from SecurityContext: {}");
            } else {
                logger.debug("Authentication object not found or not authenticated");
            }

            if (userEmail != null) {
                auditTrailService.logEvent("EndpointAccess", "System", userEmail, remoteAddress, "Accessed endpoint: " + method + " " + requestURL, true);
            } else {
                // Log unauthorized access attempt (optional)
            }
        } catch (Exception e) {
            // Log any exceptions that occur during logging
            logger.error("Error logging endpoint access: " + e.getMessage());
        }

        // Proceed with the filter chain
        filterChain.doFilter(request, response);
    }
}


