package com.jquerybuilder.test;

import java.util.Map;

import com.jquerybuilder.validation.ValidationGroup;

public class ValidationTest extends BaseTest {

  public ValidationTest() {

    data1.put("age", "17");
    data1.put("username", "ibrahim Altınoluk");

    data2.put("age", "26");
    data2.put("username", "ibrahim Altınoluk");
    data2.put("hobby", "coding");

    data3.put("age", "26");
    data3.put("username", "ibrahim Altınoluk");
    data3.put("hobby", "tenis");

    data4.put("age", "30");
    data4.put("username", "ibrahim.altinoluk");
    data4.put("hobby", "football");

    data5.put("number", "2");
    data6.put("number", "4");
    data7.put("number", "7");
    data8.put("number", "9");
    data9.put("number", "1");

    data10.put("age", "30");
    data10.put("username", "gürsel");
  }

  public void testAgeValidation() {
    Map map = gson.fromJson(readFile("input/age_validation.json"), Map.class);
    ValidationGroup validationGroup = new ValidationGroup(map);

    assertTrue(validationGroup.execute(data1));
    assertFalse(validationGroup.execute(data2));
    assertFalse(validationGroup.execute(data3));
  }

  public void testAgeValidationNot() {
    Map map = gson.fromJson(readFile("input/age_validation_not.json"), Map.class);

    ValidationGroup validationGroup = new ValidationGroup(map);

    assertTrue(validationGroup.execute(data10));
    assertFalse(validationGroup.execute(data1));

  }

  public void testHobbyValidation() {
    Map map = gson.fromJson(readFile("input/hobby_validation.json"), Map.class);

    ValidationGroup validationGroup = new ValidationGroup(map);

    assertFalse(validationGroup.execute(data1));
    assertTrue(validationGroup.execute(data2));
    assertFalse(validationGroup.execute(data3));
    assertTrue(validationGroup.execute(data4));
  }

  public void testHobbyValidationNot() {
    Map map = gson.fromJson(readFile("input/hobby_validation_not.json"), Map.class);

    ValidationGroup validationGroup = new ValidationGroup(map);

    assertFalse(validationGroup.execute(data1));
    assertFalse(validationGroup.execute(data2));
    assertTrue(validationGroup.execute(data3));
    assertFalse(validationGroup.execute(data4));
  }

  public void testNumberValidation() {
    Map map = gson.fromJson(readFile("input/validation3.json"), Map.class);

    ValidationGroup validationGroup = new ValidationGroup(map);

    assertTrue(validationGroup.execute(data5));
    assertTrue(validationGroup.execute(data6));
    assertTrue(validationGroup.execute(data7));
    assertTrue(validationGroup.execute(data8));
    assertFalse(validationGroup.execute(data9));
  }

}
