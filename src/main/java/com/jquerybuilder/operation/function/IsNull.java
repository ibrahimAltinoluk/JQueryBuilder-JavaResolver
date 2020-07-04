package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.BinaryExecutor;
import com.jquerybuilder.operation.OperationExecutor;

public class IsNull extends OperationExecutor implements BinaryExecutor {
  @Override
  public boolean apply(Object argument) {
    return argument == null;
  }
}
