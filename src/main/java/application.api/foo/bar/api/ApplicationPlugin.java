package foo.bar.api;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.function.UnaryOperator;

public interface ApplicationPlugin extends UnaryOperator<String> {

  static List<ApplicationPlugin> load() {
    List<ApplicationPlugin> plugins = new ArrayList<>();
    for (ApplicationPlugin plugin : ServiceLoader.load(ApplicationPlugin.class)) {
      plugins.add(plugin);
    }
    return plugins;
  }
}
