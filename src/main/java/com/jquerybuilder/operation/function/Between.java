package com.jquerybuilder.operation.function;

import java.util.List;
import com.jquerybuilder.operation.OperationExecutor;
import com.jquerybuilder.operation.BinaryExecutor;

public class Between extends OperationExecutor implements BinaryExecutor {
  @Override
  public boolean apply(Object number, Object range) {
    try {
      List<?> list = list(range);
      long i1 = number(number);
      long i2 = Long.parseLong(list.get(0).toString());
      long i3 = Long.parseLong(list.get(1).toString());
      return i2 > i3 ? i1 > i3 && i1 < i2 : i1 > i2 && i1 < i3;
    } catch (Exception e) {
      return false;
    }
  }

}
