package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.OperationExecutor;
import com.jquerybuilder.operation.BinaryExecutor;

public class Equal extends OperationExecutor implements BinaryExecutor {
  @Override
  public boolean apply(Object argument1, Object argument2) {
    try {
      return (argument1 == null && argument2 == null) || argument1.equals(argument2);
    } catch (Exception e) {
      return false;
    }
  }

}
