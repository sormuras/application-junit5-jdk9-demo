package foo.bar.internal;

import foo.bar.api.ApplicationPlugin;

public class Reverse implements ApplicationPlugin {

  @Override
  public String apply(String s) {
    return new StringBuilder(s).reverse().toString();
  }

}
