package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.OperationExecutor;
import com.jquerybuilder.operation.BinaryExecutor;

public final class Less extends OperationExecutor implements BinaryExecutor {

  @Override
  public boolean apply(Object less, Object greater) {
    try {
      long i1 = number(less);
      long i2 = number(greater);
      return i1 < i2;
    } catch (Exception e) {
      return false;
    }
  }

}
