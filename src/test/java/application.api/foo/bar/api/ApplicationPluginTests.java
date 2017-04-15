package foo.bar.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApplicationPluginTests {

  @Test
  void loadedPluginListIsNotEmpty() {
    Assertions.assertFalse(ApplicationPlugin.load().isEmpty(), "nothing's loaded");
  }

}
