package foo.bar.internal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseTests {

  @Test
  void reverse() {
    Assertions.assertEquals("123", new Reverse().apply("321"));
  }

}
