package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.OperationExecutor;
import com.jquerybuilder.operation.BinaryExecutor;

public class LessOrEqual extends OperationExecutor implements BinaryExecutor {
  @Override
  public boolean apply(Object less, Object greaterOrEqual ) {
    try {
      long i1 = number(less);
      long i2 = number(greaterOrEqual);
      return i1 <= i2;
    } catch (Exception e) {
      return false;
    }
  }

}
