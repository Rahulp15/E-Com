package dev.rahul.product_service.Advice;

import dev.rahul.product_service.DTOS.ErrorDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDTO> HandleNullPointerException(){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("Something went wrong. Please try again");

        return new ResponseEntity<>(errorDTO,
                HttpStatusCode.valueOf(404));
    }
}
