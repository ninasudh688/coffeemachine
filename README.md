| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | NINA SUDHEESH              |
| Date         | 10/06/2024                 |
| Course       | Fall                       |
| Assignment # | 2                          |

# Assignment Overview

- The goal of the assignment is to create a delivery notification system while using a design pattern that manage
  between different types of drivers( such as scooters, taxi, vans) and the retail stores that need orders to be
  delivered.
- The shop can create delivery requests, with all delivery details.
- When creating a request, the system creates notifications for delivery drivers, ensuring they stay aware about the
  status of upcoming or potential deliveries.
- This helps maintain smooth communication between the shop and available drivers, keeping them aware of any delivery
  updates that may be assigned to them.

# GitHub Repository Link:
https://github.com/ninasudh688/cs665assignment2
# Implementation Description

- The implementation has been kept simple and easy to understand by organizing the code.
    - Both interfaces (DeliverySubject & DeliveryObserver) helps to organize the code logically, ensuring a clean
      separation of concerns.
    - Driver class focuses on receiving delivery notifications, acting as the Concrete Observer, while the Shop class,
      acts as the Concrete Subject, manages/creates delivery requests.
    - Each class serves a distinct role making it straightforward for others to read and maintain.
    - This separation in roles helps make the code more readable.
    - Also, all the code is documented with doc-blocks that explain each method/class's purpose.


- I chose the Observer pattern because the problem emphasized the use of pushing notifications to constantly update
  Drivers about delivery.Observer pattern is used when need inform multiple object/observers about updates
  to subject state as fast as possible (e.g. such as informing multiple drivers about multiple deliveries).
  Here, the retail shop acts as the subject, and the delivery drivers are the observers.

    - The pattern enables efficient communication between the shop and the drivers, ensuring all subscribed drivers are
      updated on new deliveries changes without tightly coupling them.
        - A loosely coupled design mean that the app will be
          flexible and be handle lots of changes/updates. Observers or Drivers can be modified independently of the
          subject/Shop,
          and vice versa, making the codebase more maintainable and scalable.
        - The implementation is designed with future flexibility in mind.
            - By using the Observer Pattern ,it’s easy to add or remove new object types (such as different
              types of drivers van,scooter,bike) without modifying the core logic of the Shop.
            - I also added flexibility when I assumed that in future this app would be expanded to also notify
              observers/drivers
              of when products have been delivered so that
              not all drivers drive to pickup same delivery which is why I created handleProductsDelivered() method.


- Code duplication has been carefully avoided:
    - I did this by keeping the notification process in the DeliverySubject interface and Shop class, which ensures that
      the code for managing observers was not D.R.Y or duplicated.
    - The Shop class handles/implements all observer registration, removal, and notification processes.
    - Avoiding duplications is important here because if there was a bug in the notification process,
      then debugging and fixing it would be very hard/difficult especially if the same logic were duplicated
      in multiple places.
    - By using this pattern you would only need to make changes in one place so that everything is
      consistent and less error-prone.


- Here is how I used the Observer Pattern/Set up the classes:
    - DeliverySubject.js = Subject Interface
    - DeliveryObserver.js = Observer Interface
    - Driver.js = Concrete Observer
    - Shop.js = Concrete Subject
    - DeliveryRequest.js = Concrete Class
        - It has composition relationship with Shop since you can't send out delivery requests
          without a Store to create delivery-requests.
        - Shop has a List< DeliveryRequest >deliveryRequests objects within it.
        - A Shop can have multiple DeliveryRequest objects (1 to many).


- Assumptions that I made:
    - I assumed that Shop have store name and location address.
    - I assumed that each driver has name,vehicle type, and initial starting Address where they
      initially drive from to the delivery address.
    - I assumed that each request would need a store name,store location, delivery Address,
      products , delivery date time, and delivery status.
    - I assumed that in future this app would be expanded to also have delivered notifications which
      is why I created handleProductsDelivered() method .
    - I assumed that for now all observers are types of drivers.

# Running My Code And UML:

- I placed my UML diagram in cs665_assignment2_UMLDiagram_Sudheesh.PDF within this zipped folder
- I placed my code in package deliverydriversystem under the edu.bu.met.cs665 package.
- The Main class is outside this package.
- I tested my code using junit tests by using a JUnit test class TestDeliveryNotificationSystem in the test package.
    - I also tested some code as well in the Main class.
- The code compiles using mvn clean compile.

# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/)
on your system.

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a
standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains
information about the project, such as its dependencies, the build configuration, and the plugins used for building and
packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the
dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that
builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to
use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports,
and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile

Type on the command line:

```bash
mvn clean compile
```

## JUnit Tests

JUnit is a popular testing framework for Java. JUnit's tests are automated tests that are written to verify that the
behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is
annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the
code being tested.

JUnit's tests are executed automatically and the results of the tests are reported. This allows developers to quickly
and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code
they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all
required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time
changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for
manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:

```bash
mvn clean test
```

## Spotbugs

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool
that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems
or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and
other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately
obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to
meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the
development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues
later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential
security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.

## Checkstyle

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source
tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as
well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on
any issues or violations of the coding standards defined in its configuration. This includes issues like code style,
code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices,
making it easier for other developers to read and maintain. It can also help to identify potential issues before the
code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a
wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing
tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser.

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`




