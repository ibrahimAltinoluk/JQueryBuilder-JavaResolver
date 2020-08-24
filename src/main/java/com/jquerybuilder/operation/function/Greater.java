package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.BinaryExecutor;
import com.jquerybuilder.operation.OperationExecutor;

public class Greater extends OperationExecutor implements BinaryExecutor {
  @Override
  public boolean apply(Object greater, Object less) {
    try {
      long i1 = number(greater);
      long i2 = number(less);
      return i1 > i2;
    } catch (Exception e) {
      return false;
    }
  }

}
