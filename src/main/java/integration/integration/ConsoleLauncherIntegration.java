package integration;

import org.junit.platform.console.ConsoleLauncher;

public class ConsoleLauncherIntegration {
    public static void main(String[] args) {
        ConsoleLauncher.main(
                "--scan-classpath",
                "--classpath", "target/idea/production/application.api",
                "--classpath", "target/idea/production/integration"
        );
    }
}
