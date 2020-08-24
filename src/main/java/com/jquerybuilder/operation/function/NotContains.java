package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.OperationExecutor;
import com.jquerybuilder.operation.BinaryExecutor;

public class NotContains extends OperationExecutor implements BinaryExecutor {

  @Override
  public boolean apply(Object term, Object text) {
    try {
      return !string(text).contains(string(term));
    } catch (Exception e) {
      return false;
    }
  }
}
