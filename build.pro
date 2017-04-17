System.out.println("Java runtime: " + Runtime.version())

import static com.github.forax.pro.Pro.*;

set("pro.loglevel", "verbose")

set("resolver.dependencies", list(
  "junit.platform.console.standalone=org.junit.platform:junit-platform-console-standalone:1.0.0-M4"
))

set("packager.moduleMetadata", list(
  "application.api@1.0-SNAPSHOT",
  "integration@1.0-SNAPSHOT/integration.ConsoleLauncherIntegration"
))

set("runner.mainArguments", list(
  "--scan-classpath",
  "--classpath", "target/main/exploded/integration"
  // "--classpath", "target/test/exploded/application.api" -- needs "--permit-illegal-access"
  // class foo.bar.internal.ReverseTests (in unnamed module @0x5aa9e4eb)
  //   cannot access class foo.bar.internal.Reverse (in module application.api)
  //   because module application.api does not export foo.bar.internal to unnamed module @0x5aa9e4eb
))

run("resolver", "modulefixer", "compiler", "packager", "runner")

/exit
