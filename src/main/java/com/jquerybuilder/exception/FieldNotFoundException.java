package com.jquerybuilder.exception;

public class FieldNotFoundException extends Exception {
  public FieldNotFoundException(String detail) {
    super(detail);
  }

  public FieldNotFoundException(String detail, Throwable cause) {
    super(detail, cause);
  }
}
