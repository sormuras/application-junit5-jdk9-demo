System.out.println("java runtime: " + Runtime.version())

/env -class-path deps/junit.platform.console.standalone.jar

org.junit.platform.console.ConsoleLauncher.execute(
  System.out, System.err,
  "--scan-classpath",
  "--classpath", "src/test/java/application.api",
  "--classpath", "target/test/exploded/application.api"
)

/exit
