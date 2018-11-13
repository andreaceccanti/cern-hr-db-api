package it.infn.mw.cern.hr.api.dto;

public class ErrorDTO {

  final String error;
  final String errorMessage;

  private ErrorDTO(String error, String errorMessage) {
    this.error = error;
    this.errorMessage = errorMessage;
  }

  private ErrorDTO(String error) {
    this(error, null);
  }

  public String getError() {
    return error;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public static ErrorDTO newError(String error, String errorMessage) {
    return new ErrorDTO(error, errorMessage);
  }

  public static ErrorDTO newError(String error) {
    return new ErrorDTO(error);
  }


}
