package com.jquerybuilder.test;

import java.util.Map;
import com.jquerybuilder.exception.FieldNotFoundException;
import com.jquerybuilder.validation.ValidationGroup;

public class OperationWithValidationGroupTest extends BaseTest {

  public OperationWithValidationGroupTest() {
    data1.put("number", "11");
    data1.put("hobby", "music");

    data2.put("number", "2");
    data2.put("hobby", "tenis");

    data3.put("number", "50");
    data3.put("hobby", "painting");

    data4.put("number", "7");
    data4.put("hobby", "tenis");

    data5.put("number", "10");
    data6.put("number", "60");
  }

  public void testInOperation() throws FieldNotFoundException {
    Map map = gson.fromJson(readFile("input/operation/in.json"), Map.class);
    ValidationGroup validationGroup = new ValidationGroup(map);

    assertTrue(validationGroup.execute(data1));
    assertTrue(validationGroup.execute(data2));
    assertFalse(validationGroup.execute(data3));
    assertFalse(validationGroup.execute(data4));
  }

  public void testLessOperation() throws FieldNotFoundException {
    Map map = gson.fromJson(readFile("input/operation/less.json"), Map.class);
    ValidationGroup validationGroup = new ValidationGroup(map);

    assertFalse(validationGroup.execute(data5));
    assertTrue(validationGroup.execute(data6));
  }

  public void testBetweenOperation() throws FieldNotFoundException {
    Map map = gson.fromJson(readFile("input/operation/between.json"), Map.class);
    ValidationGroup conditionGroup = new ValidationGroup(map);

    assertFalse(conditionGroup.execute(data1));
    assertFalse(conditionGroup.execute(data5));
    assertTrue(conditionGroup.execute(data6));
  }

}
