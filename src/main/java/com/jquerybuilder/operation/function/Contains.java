package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.OperationExecutor;
import com.jquerybuilder.operation.BinaryExecutor;

public class Contains extends OperationExecutor implements BinaryExecutor {
  @Override
  public boolean apply(Object text, Object term) {
    try {
      return string(text).contains(string(term));
    } catch (Exception e) {
      return false;
    }
  }
}
