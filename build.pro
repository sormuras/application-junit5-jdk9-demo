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
))

run("resolver", "modulefixer", "compiler", "packager", "runner")

/exit
