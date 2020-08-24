package com.jquerybuilder.operation;

import java.util.List;

public class OperationExecutor {

  public Long number(Object argument) {
    return argument == null || "".equals(argument) ? 0 : Long.parseLong(String.valueOf(argument));
  }

  public List<?> list(Object argument) {
    return argument == null ? List.of() : (List<?>) argument;
  }

  protected String string(Object argument) {
    return argument == null ? "" : String.valueOf(argument);
  }
}
