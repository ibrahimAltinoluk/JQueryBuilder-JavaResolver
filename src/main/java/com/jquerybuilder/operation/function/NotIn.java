package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.BinaryExecutor;
import com.jquerybuilder.operation.OperationExecutor;

public class NotIn extends OperationExecutor implements BinaryExecutor {

  @Override
  public boolean apply(Object arg, Object listOf) {
    try {
      return !list(listOf).contains(arg);
    } catch (Exception e) {
      return false;
    }
  }
}
