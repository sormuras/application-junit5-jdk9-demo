import static com.github.forax.pro.Pro.*;

set("pro.loglevel", "info")

set("resolver.dependencies", list(
  "junit.platform.console.standalone=org.junit.platform:junit-platform-console-standalone:1.0.0-M4"
))

set("packager.moduleMetadata", list(
  "application.api@1.0-SNAPSHOT",
  "integration@1.0-SNAPSHOT/integration.ConsoleLauncherIntegration"
))

set("runner.mainArguments", list(
  "--scan-classpath",
  "--classpath", "target/idea/production/application.api",
  "--classpath", "target/idea/production/integration"
))

run("resolver", "modulefixer", "compiler", "packager", "runner")

/exit
