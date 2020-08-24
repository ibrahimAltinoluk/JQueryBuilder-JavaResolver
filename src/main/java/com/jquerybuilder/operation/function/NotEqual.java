package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.OperationExecutor;
import com.jquerybuilder.operation.BinaryExecutor;

public class NotEqual extends OperationExecutor implements BinaryExecutor {
  @Override
  public boolean apply(Object argument1, Object argument2) {
    try {
      return !String.valueOf(argument1).equals(String.valueOf(argument2));
    } catch (Exception e) {
      return false;
    }
  }

}
