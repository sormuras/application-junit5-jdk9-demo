package foo.bar.api;

import java.util.Arrays;

public class ApplicationMain {

  public static void main(String[] args) throws Exception {
    System.out.println("ApplicationVersion " + ApplicationVersion.VERSION);
    for (ApplicationPlugin plugin : ApplicationPlugin.load()) {
      System.out.println("ApplicationPlugin: " + plugin.getClass());
      apply(plugin, "123");
      apply(plugin, "abc");
      Arrays.stream(args).forEach(arg -> apply(plugin, arg));
    }
  }

  static void apply(ApplicationPlugin plugin, String input) {
    String name = plugin.getClass().getSimpleName();
    String output = plugin.apply(input);
    System.out.printf("'%s' -> [%s] -> '%s'%n", input, name, output);
  }
}
