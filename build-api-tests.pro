System.out.println("java runtime: " + Runtime.version())

/env -class-path deps/junit.platform.console.standalone.jar

//
// Looks cool, but calls "System.exit" which kills the JShell...
//

org.junit.platform.console.ConsoleLauncher.main(
  "--scan-classpath",
  "--classpath", "src/test/java/application.api",
  "--classpath", "target/test/exploded/application.api"
)

/exit

//
// Either wrap above call in a forked VM or use Launcher API as below:
//

import static com.github.forax.pro.Pro.*;

import static org.junit.platform.engine.discovery.DiscoverySelectors.*
import static org.junit.platform.engine.discovery.ClassNameFilter.*
import org.junit.platform.launcher.*
import org.junit.platform.launcher.core.*
import org.junit.platform.launcher.listeners.*

LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request().selectors(
  selectClasspathRoots(java.util.Set.of(location("target/test/exploded/application.api")))
  //selectPackage("foo.bar")
  //selectClass("foo.bar.api.ApplicationVersionTests")
).build()

Launcher launcher = LauncherFactory.create()

SummaryGeneratingListener summary = new SummaryGeneratingListener()
launcher.registerTestExecutionListeners(summary)
launcher.execute(request)

summary.getSummary().printTo(new java.io.PrintWriter(System.out))

/exit
