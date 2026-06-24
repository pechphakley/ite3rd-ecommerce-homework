package co.istad.phakley.ite3rdecommerce.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
@Slf4j
public class AppException {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleServiceException(
            ResponseStatusException e
    ) {
        ErrorResponse<?> errorResponse = ErrorResponse.builder()
                .status(false)
                .code(e.getStatusCode().value())
                .message("Service exception errored")
                .errors(e.getReason())
                .build();

        return ResponseEntity.status(e.getStatusCode())
                .body(errorResponse);
    }

}







