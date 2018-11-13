package it.infn.mw.cern.hr.error;

public class ConfigurationError extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public ConfigurationError(String message) {
    super(message);
  }
}
