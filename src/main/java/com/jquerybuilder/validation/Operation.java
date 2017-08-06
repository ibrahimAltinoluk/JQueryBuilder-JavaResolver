package com.jquerybuilder.validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operation {
  private static Map<String, Function> operationMap = new HashMap<>();

  public static boolean apply(String operation, Object v1, Object v2) {
    return operationMap.get(operation).apply(v1, v2);
  }

  private static class Function {
    public boolean apply(Object v1, Object v2) {
      return false;
    }

    public boolean apply(Object v1) {
      return false;
    }
  }

  static {
    operationMap.put("less", new Function() {

      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          long i1 = Long.parseLong(v1.toString());
          long i2 = Long.parseLong(v2.toString());
          return i1 < i2;
        } catch (Exception e) {
        }
        return false;
      }
    });
    operationMap.put("less_or_equal", new Function() {

      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          long i1 = Long.parseLong(v1.toString());
          long i2 = Long.parseLong(v2.toString());
          return i1 <= i2;
        } catch (Exception e) {
        }
        return false;
      }
    });

    operationMap.put("greater", new Function() {
      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          long i1 = Long.parseLong(v1.toString());
          long i2 = Long.parseLong(v2.toString());
          return i1 > i2;
        } catch (Exception e) {
        }
        return false;
      }
    });

    operationMap.put("greater_or_equal", new Function() {
      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          long i1 = Long.parseLong(v1.toString());
          long i2 = Long.parseLong(v2.toString());
          return i1 >= i2;
        } catch (Exception e) {
        }
        return false;
      }
    });

    operationMap.put("between", new Function() {
      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          List list = (List) v2;
          long i1 = Long.parseLong(v1.toString());
          long i2 = Long.parseLong(list.get(0).toString());
          long i3 = Long.parseLong(list.get(1).toString());
          return i2 > i3 ? i1 > i3 && i1 < i2 : i1 > i2 && i1 < i3;
        } catch (Exception e) {
        }
        return false;
      }
    });
    operationMap.put("not_between", new Function() {
      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          List list = (List) v2;
          long i1 = Long.parseLong(v1.toString());
          long i2 = Long.parseLong(list.get(0).toString());
          long i3 = Long.parseLong(list.get(1).toString());
          return !(i2 > i3 ? i1 > i3 && i1 < i2 : i1 > i2 && i1 < i3);
        } catch (Exception e) {
        }
        return false;
      }
    });
    operationMap.put("equal", new Function() {
      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          return v1.equals(v2);
        } catch (Exception e) {
        }
        return false;
      }
    });

    operationMap.put("not_equal", new Function() {
      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          return !v1.equals(v2);
        } catch (Exception e) {
        }
        return false;
      }
    });

    operationMap.put("contains", new Function() {
      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          return v1.toString().contains(v2.toString());
        } catch (Exception e) {
        }
        return false;
      }
    });

    operationMap.put("not_contains", new Function() {
      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          return !v1.toString().contains(v2.toString());
        } catch (Exception e) {
        }
        return false;
      }
    });

    operationMap.put("in", new Function() {
      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          List list = (List) v2;
          return list.contains(v1);
        } catch (Exception e) {
        }
        return false;
      }
    });

    operationMap.put("not_in", new Function() {
      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          List list = (List) v2;
          return !list.contains(v1);
        } catch (Exception e) {
        }
        return false;
      }
    });

    operationMap.put("is_null", new Function() {
      @Override
      public boolean apply(Object v1) {
        return v1 == null;
      }
    });

    operationMap.put("is_not_null", new Function() {
      @Override
      public boolean apply(Object v1) {
        return v1 != null;
      }
    });

    operationMap.put("begins_with", new Function() {
      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          return v1.toString().startsWith(v2.toString());
        } catch (Exception e) {
        }
        return false;
      }
    });

    operationMap.put("not_begins_with", new Function() {
      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          return !v1.toString().startsWith(v2.toString());
        } catch (Exception e) {
        }
        return false;
      }
    });

    operationMap.put("ends_with", new Function() {
      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          return v1.toString().endsWith(v2.toString());
        } catch (Exception e) {
        }
        return false;
      }
    });

    operationMap.put("not_ends_with", new Function() {
      @Override
      public boolean apply(Object v1, Object v2) {
        try {
          return !v1.toString().endsWith(v2.toString());
        } catch (Exception e) {
        }
        return false;
      }
    });

    operationMap.put("is_empty", new Function() {
      @Override
      public boolean apply(Object v1) {
        try {
          if (v1 instanceof List) {
            List list = ((List) v1);
            return list == null || list.isEmpty();
          } else if (v1 instanceof String) {
            return "" == v1.toString();
          }
        } catch (Exception e) {
        }
        return false;
      }
    });

    operationMap.put("is_not_empty", new Function() {
      @Override
      public boolean apply(Object v1) {
        try {
          if (v1 instanceof List) {
            List list = ((List) v1);
            return list != null && !list.isEmpty();
          } else if (v1 instanceof String) {
            return "" != v1.toString();
          }
        } catch (Exception e) {
        }
        return false;
      }
    });

  }

}
