# UI Automation Challenge
UI Automation Framework.

## Installation

###Profiles:
spring.profiles.active=dev/qa

Multi-Browser
browser=chrome/firefox

Command
mvn clean test -Dspring.profiles.active=dev -Dbrowser=chrome

-Dcucumber.options="--tags @regression"

-Dthreadcount=5

## Usage
For further reference, please consider the following sections:
```java
import foobar

# returns 'phenomenon'
foobar.singularize('phenomena')
```

## Contributing
Pull requests are welcome.

## Author
Benjamin Arce - barce

