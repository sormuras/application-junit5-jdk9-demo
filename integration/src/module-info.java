module integration {

  requires application.api;
  requires junit.platform.console.standalone;

  opens integration;

  provides foo.bar.api.ApplicationPlugin
      with integration.Uppercase;
}
