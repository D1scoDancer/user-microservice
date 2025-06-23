package d1scodancer.usermicroservice.exceptions;

import d1scodancer.usermicroservice.rest.UserController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Aleksey Shulikov
 */
@RestControllerAdvice(basePackageClasses = UserController.class)
public class ApiExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiException> handleUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(
                new ApiException(HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.getReasonPhrase(),
                        e.getMessage()),
                HttpStatus.NOT_FOUND);
    }
}
