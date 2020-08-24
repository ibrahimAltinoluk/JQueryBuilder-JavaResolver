package com.jquerybuilder.test;

import java.util.Arrays;
import com.jquerybuilder.operation.Operation;

public class OperationTest extends BaseTest {


  public void testLessOperation() {
    assertTrue(Operation.Less.apply(1, 2));
    // null is 0
    assertTrue(Operation.Less.apply(null, 1));
    // empty is 0
    assertTrue(Operation.Less.apply("", 1));
    assertFalse(Operation.Less.apply(2, 1));
  }

  public void testLessOrEqualOperation() {
    assertTrue(Operation.LessOrEqual.apply(1, 1));
    assertTrue(Operation.LessOrEqual.apply(1, 2));
    assertFalse(Operation.LessOrEqual.apply(2, 1));
  }

  public void testGreaterOperation() {
    assertTrue(Operation.Greater.apply(2, 1));
    assertFalse(Operation.Greater.apply(1, 2));
    // null is 0
    assertFalse(Operation.Greater.apply(null, 1));
    // empty is 0
    assertFalse(Operation.Greater.apply("", 1));
  }

  public void testGreaterOrEqualOperation() {
    assertTrue(Operation.GreaterOrEqual.apply(2, 1));
    assertTrue(Operation.GreaterOrEqual.apply(1, 1));
  }

  public void testBetweenOperation() {
    assertTrue(Operation.Between.apply(3, Arrays.asList(1, 5)));
  }

  public void testNotBetweenOperation() {
    assertTrue(Operation.NotBetween.apply(10, Arrays.asList(1, 5)));
  }

  public void testEqualOperation() {
    assertTrue(Operation.Equal.apply(1, 1));
    assertTrue(Operation.Equal.apply("", ""));
    assertTrue(Operation.Equal.apply("a", "a"));
    assertTrue(Operation.Equal.apply(null, null));
    assertFalse(Operation.Equal.apply(null, ""));
    assertFalse(Operation.Equal.apply("", " "));
    assertFalse(Operation.Equal.apply("", "\t"));
  }

  public void testNotEqualOperation() {
    assertTrue(Operation.NotEqual.apply(null, ""));
    assertTrue(Operation.NotEqual.apply("", " "));
    assertTrue(Operation.NotEqual.apply("", "\t"));
    assertTrue(Operation.NotEqual.apply(1, 2));
    assertFalse(Operation.NotEqual.apply(1, 1));
    assertFalse(Operation.NotEqual.apply("", ""));
    assertFalse(Operation.NotEqual.apply("a", "a"));
    assertFalse(Operation.NotEqual.apply(null, null));
  }

  public void testContainsOperation() {
    assertTrue(Operation.Contains.apply("abc", "a"));
    assertTrue(Operation.Contains.apply("abc", "b"));
    assertTrue(Operation.Contains.apply("abc", "c"));
    assertTrue(Operation.Contains.apply("abc", "ab"));
    assertFalse(Operation.Contains.apply("abc", "ac"));
  }

  public void testNotContainsOperation() {
    assertTrue(Operation.NotContains.apply("x", "abc"));
    assertFalse(Operation.NotContains.apply("a", "abc"));
    assertFalse(Operation.NotContains.apply("b", "abc"));
  }

  public void testInOperation() {
    assertTrue(Operation.In.apply("b", Arrays.asList("a", "b", "c")));
    assertTrue(Operation.In.apply("c", Arrays.asList("a", "b", "c")));
    assertTrue(Operation.In.apply("a", Arrays.asList("a", "b", "c")));
    assertFalse(Operation.In.apply("x", Arrays.asList("a", "b", "c")));
    assertFalse(Operation.In.apply(null, Arrays.asList("a", "b", "c")));
    assertFalse(Operation.In.apply("", Arrays.asList("a", "b", "c")));
  }

  public void testNotInOperation() {
    assertTrue(Operation.NotIn.apply("x", Arrays.asList("a", "b", "c")));
    assertTrue(Operation.NotIn.apply(null, Arrays.asList("a", "b", "c")));
    assertTrue(Operation.NotIn.apply("", Arrays.asList("a", "b", "c")));
    assertFalse(Operation.NotIn.apply("a", Arrays.asList("a", "b", "c")));
    assertFalse(Operation.NotIn.apply("b", Arrays.asList("a", "b", "c")));
    assertFalse(Operation.NotIn.apply("c", Arrays.asList("a", "b", "c")));
  }

  public void testIsNullOperation() {
    assertTrue(Operation.IsNull.apply(null));
    assertFalse(Operation.IsNull.apply(1));
    assertFalse(Operation.IsNull.apply(""));
    assertFalse(Operation.IsNull.apply("a"));
  }

  public void testIsNotNullOperation() {
    assertFalse(Operation.IsNotNull.apply(null));
    assertTrue(Operation.IsNotNull.apply(1));
    assertTrue(Operation.IsNotNull.apply(""));
    assertTrue(Operation.IsNotNull.apply("a"));
  }

  public void testBeginsWithOperation() {
    assertTrue(Operation.BeginsWith.apply("", "abc"));
    assertTrue(Operation.BeginsWith.apply("A", "abc"));
    assertTrue(Operation.BeginsWith.apply("a", "abc"));
    assertFalse(Operation.BeginsWith.apply("b", "abc"));
  }

  public void testNotBeginsWithOperation() {
    assertTrue(Operation.NotBeginsWith.apply("b", "abc"));
    assertTrue(Operation.NotBeginsWith.apply("", "abc"));
    assertFalse(Operation.NotBeginsWith.apply("a", "abc"));
  }

  public void testEndsWithOperation() {
    assertTrue(Operation.EndsWith.apply("c", "abc"));
    assertTrue(Operation.EndsWith.apply("C", "abc"));
    assertTrue(Operation.EndsWith.apply("", "abc"));
    assertFalse(Operation.EndsWith.apply("a", "abc"));
  }

  public void testNotEndsWithOperation() {
    assertTrue(Operation.NotEndsWith.apply("a", "abc"));
    assertFalse(Operation.NotEndsWith.apply("c", "abc"));
    assertFalse(Operation.NotEndsWith.apply("C", "abc"));
    assertFalse(Operation.NotEndsWith.apply("", "abc"));
  }

  public void testIsEmptyOperation() {
    assertTrue(Operation.IsEmpty.apply(""));
    assertFalse(Operation.IsEmpty.apply(null));
    assertFalse(Operation.IsEmpty.apply("a"));
    assertFalse(Operation.IsEmpty.apply(1));
  }

  public void testIsNotEmptyOperation() {
    assertTrue(Operation.IsNotEmpty.apply("a"));
    assertFalse(Operation.IsNotEmpty.apply(""));
    assertFalse(Operation.IsNotEmpty.apply(null));
  }

}
