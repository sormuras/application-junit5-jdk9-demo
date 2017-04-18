System.out.println("java runtime: " + Runtime.version())

#
# Why does /env _restart_ the entire "tests.pro" file?
#

/env -class-path deps/junit.platform.console.standalone.jar

import java.io.*

ByteArrayOutputStream out = new ByteArrayOutputStream()
ByteArrayOutputStream err = new ByteArrayOutputStream()

org.junit.platform.console.ConsoleLauncher.execute(
  new PrintStream(out, true, "UTF-8"),
  new PrintStream(err, true, "UTF-8"),
  "--scan-classpath",
  "--classpath", "src/test/java/application.api",
  "--classpath", "target/test/exploded/application.api"
)

System.out.println(out)
System.err.println(err)

/exit
