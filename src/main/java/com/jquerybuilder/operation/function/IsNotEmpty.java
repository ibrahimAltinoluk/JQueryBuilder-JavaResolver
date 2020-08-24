package com.jquerybuilder.operation.function;

import java.util.List;
import com.jquerybuilder.operation.UnaryExecutor;
import com.jquerybuilder.operation.OperationExecutor;

public class IsNotEmpty extends OperationExecutor implements UnaryExecutor {
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
