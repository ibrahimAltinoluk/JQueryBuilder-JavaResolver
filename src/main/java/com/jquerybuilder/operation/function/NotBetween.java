package com.jquerybuilder.operation.function;

import java.util.List;
import com.jquerybuilder.operation.OperationExecutor;
import com.jquerybuilder.operation.UnaryExecutor;

public class NotBetween extends OperationExecutor implements UnaryExecutor {
  @Override
  public boolean apply(Object argument1, Object argument2) {
    try {
      List<?> list = list(argument2);
      long i1 = number(argument1);
      long i2 = Long.parseLong(list.get(0).toString());
      long i3 = Long.parseLong(list.get(1).toString());
      return !(i2 > i3 ? i1 > i3 && i1 < i2 : i1 > i2 && i1 < i3);
    } catch (Exception e) {
      return false;
    }
  }

}
