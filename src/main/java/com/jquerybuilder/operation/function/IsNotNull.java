package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.UnaryExecutor;
import com.jquerybuilder.operation.OperationExecutor;

public class IsNotNull extends OperationExecutor implements UnaryExecutor {
  @Override
  public boolean apply(Object argument) {
    return argument != null;
  }
}
