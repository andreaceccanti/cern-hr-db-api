package it.infn.mw.cern.hr.api.error;

public class NotFoundError extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public NotFoundError(String message) {
    super(message);
  }

}
