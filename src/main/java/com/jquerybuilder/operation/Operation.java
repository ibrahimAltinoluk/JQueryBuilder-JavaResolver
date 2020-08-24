package com.jquerybuilder.operation;

import java.util.HashMap;
import java.util.Map;
import com.jquerybuilder.operation.function.BeginsWith;
import com.jquerybuilder.operation.function.Between;
import com.jquerybuilder.operation.function.Contains;
import com.jquerybuilder.operation.function.EndsWith;
import com.jquerybuilder.operation.function.Equal;
import com.jquerybuilder.operation.function.Greater;
import com.jquerybuilder.operation.function.GreaterOrEqual;
import com.jquerybuilder.operation.function.In;
import com.jquerybuilder.operation.function.IsEmpty;
import com.jquerybuilder.operation.function.IsNotEmpty;
import com.jquerybuilder.operation.function.IsNotNull;
import com.jquerybuilder.operation.function.IsNull;
import com.jquerybuilder.operation.function.Less;
import com.jquerybuilder.operation.function.LessOrEqual;
import com.jquerybuilder.operation.function.NotBeginsWith;
import com.jquerybuilder.operation.function.NotBetween;
import com.jquerybuilder.operation.function.NotContains;
import com.jquerybuilder.operation.function.NotEndsWith;
import com.jquerybuilder.operation.function.NotEqual;
import com.jquerybuilder.operation.function.NotIn;

public class Operation {
  private static Map<String, OperationExecutor> operationMap = new HashMap<>();
  public static final Less Less = new Less();
  public static final LessOrEqual LessOrEqual = new LessOrEqual();
  public static final Greater Greater = new Greater();
  public static final GreaterOrEqual GreaterOrEqual = new GreaterOrEqual();
  public static final Between Between = new Between();
  public static final NotBetween NotBetween = new NotBetween();
  public static final Equal Equal = new Equal();
  public static final NotEqual NotEqual = new NotEqual();
  public static final Contains Contains = new Contains();
  public static final NotContains NotContains = new NotContains();
  public static final In In = new In();
  public static final NotIn NotIn = new NotIn();
  public static final IsNull IsNull = new IsNull();
  public static final IsNotNull IsNotNull = new IsNotNull();
  public static final BeginsWith BeginsWith = new BeginsWith();
  public static final NotBeginsWith NotBeginsWith = new NotBeginsWith();
  public static final EndsWith EndsWith = new EndsWith();
  public static final NotEndsWith NotEndsWith = new NotEndsWith();
  public static final IsEmpty IsEmpty = new IsEmpty();
  public static final IsNotEmpty IsNotEmpty = new IsNotEmpty();

  static {
    operationMap.put("less", Less);
    operationMap.put("less_or_equal", LessOrEqual);
    operationMap.put("greater", Greater);
    operationMap.put("greater_or_equal", GreaterOrEqual);
    operationMap.put("between", Between);
    operationMap.put("not_between", NotBetween);
    operationMap.put("equal", Equal);
    operationMap.put("not_equal", NotEqual);
    operationMap.put("contains", Contains);
    operationMap.put("not_contains", NotContains);
    operationMap.put("in", In);
    operationMap.put("not_in", NotIn);
    operationMap.put("is_null", IsNull);
    operationMap.put("is_not_null", IsNotNull);
    operationMap.put("begins_with", BeginsWith);
    operationMap.put("not_begins_with", NotBeginsWith);
    operationMap.put("ends_with", EndsWith);
    operationMap.put("not_ends_with", NotEndsWith);
    operationMap.put("is_empty", IsEmpty);
    operationMap.put("is_not_empty", IsNotEmpty);

  }

  public static boolean apply(String operation, Object v1) {
    Object operator = operationMap.get(operation);
    return ((UnaryExecutor) operator).apply(v1);
  }

  public static boolean apply(String operation, Object v1, Object v2) {
    Object operator = operationMap.get(operation);
    return ((BinaryExecutor) operator).apply(v1, v2);
  }
}
