package com.jquerybuilder.operation.function;

import java.util.List;
import com.jquerybuilder.operation.BinaryExecutor;
import com.jquerybuilder.operation.OperationExecutor;

public class IsNotEmpty extends OperationExecutor implements BinaryExecutor {
  @Override
  public boolean apply(Object argument) {
    try {
      if (argument instanceof List) {
        List<?> list = list(argument);
        return list != null && !list.isEmpty();
      } else if (argument instanceof String) {
        return !"".equals(argument);
      }
    } catch (Exception e) {
    }
    return false;
  }
}
