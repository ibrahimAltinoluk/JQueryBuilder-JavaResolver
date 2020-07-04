package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.OperationExecutor;
import com.jquerybuilder.operation.UnaryExecutor;

public class GreaterOrEqual extends OperationExecutor implements UnaryExecutor {
  @Override
  public boolean apply(Object argument1, Object argument2) {
    try {
      long i1 = number(argument1);
      long i2 = number(argument2);
      return i1 >= i2;
    } catch (Exception e) {
      return false;
    }
  }

}
