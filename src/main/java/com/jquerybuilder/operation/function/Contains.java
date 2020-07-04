package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.OperationExecutor;
import com.jquerybuilder.operation.UnaryExecutor;

public class Contains extends OperationExecutor implements UnaryExecutor {
  @Override
  public boolean apply(Object term, Object text) {
    try {
      return string(text).contains(string(term));
    } catch (Exception e) {
      return false;
    }
  }
}
