package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.OperationExecutor;
import com.jquerybuilder.operation.UnaryExecutor;

public class EndsWith extends OperationExecutor implements UnaryExecutor {

  @Override
  public boolean apply(Object term, Object text) {
    return string(text).toLowerCase().endsWith(string(term).toLowerCase());
  }
}
