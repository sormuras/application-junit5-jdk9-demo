package integration;

import foo.bar.api.ApplicationPlugin;
import foo.bar.api.ApplicationVersion;
import java.util.List;
import java.util.stream.Collectors;
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

  @Test
  void loadedPluginListToStringMatches() {
    List<String> actual = ApplicationPlugin.load().stream().map(Object::toString).collect(Collectors.toList());
    actual.sort(String::compareTo);
    Assertions.assertLinesMatch(List.of("^foo.bar.internal.Reverse.*", "^integration.Uppercase.*"), actual);
  }

}
