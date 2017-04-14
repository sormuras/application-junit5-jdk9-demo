package integration;

import foo.bar.api.ApplicationPlugin;
import foo.bar.api.ApplicationVersion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegrationTests {

  @Test
  void versionIsAccessible() {
    Assertions.assertEquals("9.123", ApplicationVersion.VERSION);
  }

  @Test
  void loadedPluginListIsNotEmpty() {
    Assertions.assertFalse(ApplicationPlugin.load().isEmpty(), "nothing's loaded");
  }

}
