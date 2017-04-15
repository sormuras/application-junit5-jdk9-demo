module integration {

  requires application.api;
  requires junit.platform.console.standalone;

  opens integration
      to junit.platform.console.standalone;

  provides foo.bar.api.ApplicationPlugin
      with integration.Uppercase;
}
