package com.jquerybuilder.validation;

import java.util.Map;
import com.jquerybuilder.exception.FieldNotFoundException;
import com.jquerybuilder.operation.Operation;

public class ValidationRule {
  private String id;
  private String field;
  private String type;
  private String operator;
  private Object value;

  public ValidationRule(Map map) {
    build(map);
  }

  public void build(Map<String, String> map) {
    this.id = map.get("id");
    this.field = map.get("field");
    this.type = map.get("type");
    this.operator = map.get("operator");
    this.value = map.get("value");
  }

  public boolean execute(Map data) throws FieldNotFoundException {
    if (!data.containsKey(field)) {
      throw new FieldNotFoundException("(field:" + field + ") not found in map");
    }
    String rawDataValue = String.valueOf(data.get(field));
    return Operation.apply(operator, rawDataValue, value);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }
}
