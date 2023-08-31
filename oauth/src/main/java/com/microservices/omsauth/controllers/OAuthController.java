package com.microservices.omsauth.controllers;

import com.microservices.omsauth.exceptions.OAuthAuthenticationException;
import com.microservices.omsauth.services.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.microservices.omsauth.utility.Constants.*;

/**
 * @author bilal.ashraf
 */
@RestController
@RequestMapping("/")
public class OAuthController {

    @Autowired
    private OAuthService oAuthService;

    @GetMapping
    public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        // Delegate to service layer to check authentication
        return oAuthService.getCurrentUser(oAuth2AuthenticationToken);
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Delegate to service layer to handle logout
        return oAuthService.logout(request, response);
    }

    /**
     * Exception handler for custom OAuth authentication failures
     */
    @ExceptionHandler(OAuthAuthenticationException.class)
    public ResponseEntity<String> handleOAuthAuthFailure(OAuthAuthenticationException ex) {
        // Return an error response with appropriate status code and error message
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

}
