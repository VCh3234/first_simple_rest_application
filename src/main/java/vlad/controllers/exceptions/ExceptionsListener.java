package vlad.controllers.exceptions;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vlad.controllers.ApiController;
import vlad.dao.UsersDAO;

import javax.persistence.NoResultException;

@ControllerAdvice(basePackageClasses = ApiController.class)
public class ExceptionsListener {
    @ExceptionHandler()
    private ResponseEntity<SimpleWrapperForExceptions> exceptionHandler(Throwable exception) {
        SimpleWrapperForExceptions simpleWrapperForExceptions = new SimpleWrapperForExceptions(exception.getMessage());
        return new ResponseEntity<>(simpleWrapperForExceptions, HttpStatus.BAD_REQUEST);
    }
}
