package integration;

import foo.bar.api.ApplicationMain;

public class LegacyTest {

  @org.junit.Test
  public void testApplicationMain() {
    org.junit.Assert.assertEquals("ApplicationMain", ApplicationMain.class.getSimpleName());
  }

}
