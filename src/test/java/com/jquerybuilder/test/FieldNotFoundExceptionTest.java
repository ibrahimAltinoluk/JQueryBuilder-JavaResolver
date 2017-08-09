package com.jquerybuilder.test;

import java.util.Map;

import com.jquerybuilder.exception.FieldNotFoundException;
import com.jquerybuilder.validation.ValidationGroup;

public class FieldNotFoundExceptionTest extends BaseTest {

  public FieldNotFoundExceptionTest() {
    data1.put("foo", "bar");
  }

  public void testInOperation() {
    Map map = gson.fromJson(readFile("input/operation/in.json"), Map.class);
    ValidationGroup validationGroup = new ValidationGroup(map);

    Exception exception = null;
    try {
      validationGroup.execute(data1);
    } catch (Exception e) {
      exception = e;
    }
    assertNotNull(exception);
    assertTrue(exception instanceof FieldNotFoundException);
    assertEquals("(field:number) not found in map", exception.getMessage());
  }

}