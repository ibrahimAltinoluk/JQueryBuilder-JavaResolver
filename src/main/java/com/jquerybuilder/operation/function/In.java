package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.OperationExecutor;
import com.jquerybuilder.operation.BinaryExecutor;

public class In extends OperationExecutor implements BinaryExecutor {

  @Override
  public boolean apply(Object arg, Object list) {
    try {
      return list(list).contains(arg);
    } catch (Exception e) {
      return false;
    }
  }
}
