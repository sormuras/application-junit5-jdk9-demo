module application.api {
  exports foo.bar.api;

  uses foo.bar.api.ApplicationPlugin;

  provides foo.bar.api.ApplicationPlugin
      with foo.bar.internal.Reverse;
}
