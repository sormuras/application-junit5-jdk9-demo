# junit5-idea-java9-consumer

The `junit5-idea-java9-consumer` project demonstrates how to run tests based on
JUnit Platform standalone distribution using IDEA in the a modular environment.

This sample project does not aim to demonstrate how to use the JUnit Jupiter APIs.
For detailed  information on the JUnit Jupiter programming and extension models,
please consult the [User Guide](http://junit.org/junit5/docs/current/user-guide/).


## overview

![](readme-junit5-idea-java9-project-tree-overview.png)

This project hosts 2 (two) **Java modules**:

- `application.api`
- `integration`

and a single **IDEA module** without a `module-info.java` file:

- `application.api-tests`

## shared run configurations

### run ApplicationMain
```
jdk-9/bin/java

 -p [...]/target/idea/production/application.api

 -m application.api/foo.bar.api.ApplicationMain

ApplicationVersion 9.123
ApplicationPlugin: class foo.bar.internal.Reverse
'123' -> [Reverse] -> '321'
'abc' -> [Reverse] -> 'cba'
```

### run IntegrationMain
```
jdk-9/bin/java

 -p [...]/target/idea/production/integration
    [...]/target/idea/production/application.api
    [~m2]/junit-platform-console-standalone-1.0.0-M4.jar

 -m application.api/foo.bar.api.ApplicationMain

ApplicationVersion 9.123
ApplicationPlugin: class foo.bar.internal.Reverse
'123' -> [Reverse] -> '321'
'abc' -> [Reverse] -> 'cba'
ApplicationPlugin: class integration.Uppercase
'123' -> [Uppercase] -> '123'
'abc' -> [Uppercase] -> 'ABC'
```

### run ConsoleLauncherIntegration
```
jdk-9/bin/java

 -p [...]/target/idea/production/integration
    [...]/target/idea/production/application.api
    [~m2]/junit-platform-console-standalone-1.0.0-M4.jar

 -m integration/integration.ConsoleLauncherIntegration

 --scan-classpath
 --classpath target/idea/production/application.api
 --classpath target/idea/production/integration

╷
├─ JUnit Jupiter ✔
│  └─ IntegrationTests ✔
│     ├─ versionIsAccessible() ✔
│     ├─ loadedPluginListIsNotEmpty() ✔
│     └─ loadedPluginListToStringMatches() ✔
└─ JUnit Vintage ✔
   └─ integration.LegacyTest ✔
      └─ testApplicationMain ✔
```


## known issues

- When launching *Run 'All Test'* in `integration` service loading does not work.
- Instead of using `--scan-classpath --classpath ... --classpath ...` command
  line options, the JUnit Platform ConsoleLauncher should support something like:
  `--scan-modulepath`
- Forwarding `integration.ConsoleLauncherIntegration` wrapper should not be
  necessary.