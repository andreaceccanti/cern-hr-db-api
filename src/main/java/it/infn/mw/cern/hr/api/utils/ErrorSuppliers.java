package it.infn.mw.cern.hr.api.utils;

import java.util.function.Supplier;

import it.infn.mw.cern.hr.api.error.NotFoundError;

public class ErrorSuppliers {

  private ErrorSuppliers() {
    // prevent instantiation
  }
  
  public static Supplier<NotFoundError> notFoundError(String message) {
    return () -> new NotFoundError(message);
  }

}
