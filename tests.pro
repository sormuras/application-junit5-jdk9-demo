/env -class-path deps/junit.platform.console.standalone.jar

import java.io.*

ByteArrayOutputStream out = new ByteArrayOutputStream()
ByteArrayOutputStream err = new ByteArrayOutputStream()

org.junit.platform.console.ConsoleLauncher.execute(
  new PrintStream(out, true, "UTF-8"),
  new PrintStream(err, true, "UTF-8"),
  "--scan-classpath",
  "--classpath", "target/test/exploded/application.api"
)

System.out.println(out)
System.err.println(err)

/exit
