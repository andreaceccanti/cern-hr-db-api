package it.infn.mw.cern.hr.api.error;

import static it.infn.mw.cern.hr.api.dto.ErrorDTO.newError;

import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import it.infn.mw.cern.hr.api.dto.ErrorDTO;

@RestControllerAdvice
public class ApiExceptionHandler {

  @ResponseStatus(code=HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundError.class)
  public ErrorDTO handleNotFoundError(NotFoundError e) {
    return newError(HttpStatus.NOT_FOUND.name(), e.getMessage());
  }
  
  @ResponseStatus(code=HttpStatus.BAD_REQUEST)
  @ExceptionHandler(DateTimeParseException.class)
  public ErrorDTO handleDateTimeParseException(DateTimeParseException e) {
    return newError(HttpStatus.BAD_REQUEST.name(), e.getMessage());
  }

}
