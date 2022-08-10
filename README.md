# Java Eval



## Build instructions
You will need version 11 of the JDK and the latest version of Apache Maven to compile and run this project

Run the following command to build and package each of the projects
```
mvn clean package
```
Then run the following command to run the generated jar file in each of the projects's folders
```
java -jar target\{project-name}-0.0.1-SNAPSHOT.jar
```
where project-name = backend, ms-signup , ms-newlogin or ms-consumer
