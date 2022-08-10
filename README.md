# Java Eval



## Build instructions
You will need version 11 of the JDK and the latest version of Gradle to compile and run this project

Run the following command to build and package each of the projects
```
gradle clean build
```
Then run the following command to run the generated jar file in each of the projects's folders
```
java -jar build\libs\{project-name}-0.0.1-SNAPSHOT.jar
```
where project-name = backend, ms-signup , ms-newlogin or ms-consumer
