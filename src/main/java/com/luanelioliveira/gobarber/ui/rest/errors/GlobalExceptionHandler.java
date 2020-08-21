package com.luanelioliveira.gobarber.ui.rest.errors;

import com.luanelioliveira.gobarber.infrastructure.valueobjects.exceptions.BusinessException;
import com.luanelioliveira.gobarber.infrastructure.valueobjects.exceptions.NotFoundException;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public ErrorResponse handleNotFoundException(NotFoundException ex) {

    return ErrorResponse.of("Resource not found", ex.getMessage());
  }

  @ExceptionHandler(BusinessException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ResponseBody
  public ErrorResponse handleBusinessException(BusinessException ex) {

    return ErrorResponse.of("Business error occurred", ex.getMessage());
  }

  @ExceptionHandler({RuntimeException.class, Exception.class})
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  @ResponseBody
  public ErrorResponse handleException(Exception ex) {

    log.error("Unexpected error occurred", ex);
    return ErrorResponse.of("Unexpected error occurred", ex.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorResponse handleInputValidationExceptions(MethodArgumentNotValidException ex) {

    var invalidParamList =
        ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(fe -> InvalidParam.of(fe.getField(), fe.getDefaultMessage()))
            .collect(Collectors.toList());

    return ErrorResponse.of(
        "Parâmetros inválidos",
        "Um ou mais dados necessários não foram enviados",
        invalidParamList);
  }
}
