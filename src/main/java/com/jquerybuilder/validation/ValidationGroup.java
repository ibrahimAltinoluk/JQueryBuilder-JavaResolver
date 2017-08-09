package com.jquerybuilder.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ValidationGroup {

  public enum Condition {
    AND, OR;
    public static Condition get(Object v) {
      return Condition.valueOf(v.toString().toUpperCase());
    }
  }

  private final String CONDITION = "condition";
  private final String NOT = "not";
  private final String RULES = "rules";

  private List<ValidationGroup> validationGroups = new ArrayList<>();
  private List<ValidationRule> rules = new ArrayList<>();

  private Condition condition;
  private boolean not = false;

  public ValidationGroup(Map map) {
    build(map);
  }

  private void build(Map map) {
    Condition condition = Condition.get(map.get(CONDITION));
    this.condition = condition;
    this.not = Boolean.valueOf(map.get(NOT).toString());

    for (Map rulesMap : ((List<Map>) map.get(RULES))) {
      if (rulesMap.containsKey(CONDITION)) {
        this.validationGroups.add(new ValidationGroup(rulesMap));
      } else {
        rules.add(new ValidationRule(rulesMap));
      }
    }
  }

  public boolean execute(Map data) {

    Boolean result = null;

    for (ValidationRule rule : rules) {
      boolean ruleResult = rule.execute(data);
      if (result == null) {
        result = ruleResult;
      } else if (Condition.AND.equals(condition)) {
        result &= ruleResult;
      } else {
        result |= ruleResult;
      }
    }
    for (ValidationGroup validationGroup : validationGroups) {
      boolean ruleResult = validationGroup.execute(data);
      if (result == null) {
        result = ruleResult;
      if (Condition.AND.equals(condition)) {
        result &= ruleResult;
      } else {
        result |= ruleResult;
      }
    }

    return not ? !result : result;
  }

}
