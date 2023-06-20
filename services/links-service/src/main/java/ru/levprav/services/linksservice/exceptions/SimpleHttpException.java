package ru.levprav.services.linksservice.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class SimpleHttpException extends ResponseStatusException {
    public SimpleHttpException(HttpStatusCode status, String message) {
        super(status, message);
    }
}