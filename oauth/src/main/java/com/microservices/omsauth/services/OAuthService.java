package com.microservices.omsauth.services;

import com.microservices.omsauth.exceptions.OAuthAuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.microservices.omsauth.utility.Constants.*;

/**
 * @author bilal.ashraf
 */
@Service
public class OAuthService {

    public Map<String, Object> getCurrentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        // Check if user is authenticated
        if (oAuth2AuthenticationToken == null || !oAuth2AuthenticationToken.isAuthenticated()) {
            // Throw custom exception for authentication failure
            throw new OAuthAuthenticationException(AUTHENTICATION_FAILURE);
        }
        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
    }

    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Invalidate the session and redirect to the logout URL
        request.getSession().invalidate();
        response.sendRedirect(LOGOUT_URL);
        return SUCCESSFUL_LOGOUT;
    }

}
