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

```java
Command Line Execution

# returns 'phenomenon'
foobar.singularize('phenomena')
```

```java
IDE Execution

# returns 'phenomenon'
foobar.singularize('phenomena')
```
## Reporting

###Profiles:
spring.profiles.active=dev/qa

Multi-Browser
browser=chrome/firefox

Command
mvn clean test -Dspring.profiles.active=dev -Dbrowser=chrome

-Dcucumber.options="--tags @regression"

-Dthreadcount=5


## Contributing
Pull requests are welcome.

## Author
Feel free to ask [Benjamin Arce](benjamin_arce1991@hotmail.com) if you need some support or there are any questions.