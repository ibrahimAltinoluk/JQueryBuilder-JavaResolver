package com.jquerybuilder.operation.function;

import com.jquerybuilder.operation.OperationExecutor;
import com.jquerybuilder.operation.UnaryExecutor;

public class NotBeginsWith extends OperationExecutor implements UnaryExecutor {

  @Override
  public boolean apply(Object term, Object text) {
    String trm = string(term);
    String txt = string(text);
    if ("".equals(trm) && !"".equals(txt)) {
      return true;
    }
    return !txt.startsWith(trm);
  }
}
