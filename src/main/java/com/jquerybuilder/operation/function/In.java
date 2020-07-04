package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.OperationExecutor;
import com.jquerybuilder.operation.UnaryExecutor;

public class In extends OperationExecutor implements UnaryExecutor {

  @Override
  public boolean apply(Object argument1, Object argument2) {
    try {
      return list(argument2).contains(argument1);
    } catch (Exception e) {
      return false;
    }
  }
}
