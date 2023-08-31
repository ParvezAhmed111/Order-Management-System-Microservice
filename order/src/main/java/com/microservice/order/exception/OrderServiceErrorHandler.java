package com.microservice.order.exception;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microservice.order.constants.ServiceConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class OrderServiceErrorHandler {

    public Mono<ServerResponse> orderResponseErrorHandler(Throwable error) {
        String responseBody = error.getMessage();
        if (responseBody.contains(ServiceConstants.INSUFFICIENT_QUANTITY)) {
            return ServerResponse.status(HttpStatus.FORBIDDEN)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(getResponseBody(responseBody));
        } else {
            return ServerResponse.status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(getResponseBody(responseBody));
        }
    }

    private String getResponseBody(String responseBody){
        JsonObject response = new JsonObject();
        response.addProperty(ServiceConstants.MESSAGE, responseBody);
        return response.toString();
    }
}
