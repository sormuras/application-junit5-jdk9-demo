package foo.bar.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApplicationVersionTests {

  @Test
  void majorIsNine() {
    Assertions.assertEquals("9", ApplicationVersion.MAJOR);
  }

  @Test
  void version() {
    Assertions.assertEquals("9.123", ApplicationVersion.VERSION);
  }

}
