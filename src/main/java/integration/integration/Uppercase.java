package integration;

import foo.bar.api.ApplicationPlugin;

public class Uppercase implements ApplicationPlugin {

  @Override
  public String apply(String input) {
    return input.toUpperCase();
  }

}
