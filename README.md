# UI Automation Framework
This is a BDD framework that was built with SpringBoot taking whole the advantages of Spring. 

## Getting Started

These instructions will present a guide on how to execute this project.

### Prerequisites

* Java 11
* Maven

### Installing

Pull the project to your working directory, and add the following dependency to POM.

### Dependencies

Currently are in use the following dependencies.

|Artifact ID                	|   
|---                        	|
|spring-boot-starter			|
|spring-boot-starter-test		|
|selenium-java              	|
|webdrivermanager           	|
|cucumber-spring            	|
|cucumber-java              	|
|cucumber-testng            	|
|testng                     	|
|lombok                     	|
|assertj-core              	|
|cucumber-reporting        	|

### Usage
This framework is configurable for different properties like:
-Parallelism Thread Count
-Browser (chrome/firefox)
-Profiles (qa/dev/prod) 
-Cucumber tags

```java
Command Line Execution

Execution without report:
mvn clean test

Execution with report:
mvn clean verify

Execution without report and dev profile:
mvn clean test -Dspring.profiles.active=dev

Execution without report and specific browser:
mvn clean test -Dbrowser=chrome

Execution without report and specific tags:
mvn clean test -Dcucumber.options="--tags @regression"

Execution without report and specific number of threads:
mvn clean test -Dthreadcount=5

Execution all options:
mvn clean test -Dbrowser=chrome -Dspring.profiles.active=dev -Dcucumber.options="--tags @regression" -Dthreadcount=5
```

```java
IDE Execution

Open the TestRunner class and execute that class in order to execute the tests
```

## Contributing
Pull requests are welcome.

## Author
Feel free to ask [Benjamin Arce](benjamin_arce1991@hotmail.com) if you need some support or there are any questions.