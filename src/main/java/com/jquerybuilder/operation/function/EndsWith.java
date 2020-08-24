package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.OperationExecutor;
import com.jquerybuilder.operation.BinaryExecutor;

public class EndsWith extends OperationExecutor implements BinaryExecutor {

  @Override
  public boolean apply(Object term, Object text) {
    return string(text).toLowerCase().endsWith(string(term).toLowerCase());
  }
}
