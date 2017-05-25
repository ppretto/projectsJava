# projectsJava


ClimbingStairs project

This contains the source code for solution Climbing Stairs.

Environment development (frameworks/tools)

Eclipse NEON, Tomcat 7.0.X, Maven(apache-maven-3.3.3), Java 8(JDK 1.8.0_65), Jersey,Jackson,JUnit

In order to run the tests and build the project, you will need to install Tomcat 7.0.X. or other version and environment variables Java e Maven

To compile and run on Eclipse :

Import the project as a Maven Project

Access Properties of project and click in Deployment Assembly please check if
the variables M2_REPO appear in Web Deployment Assembly. If you don't see these variables
click on ADD==>Java Build Path Entries==>Next (will appear the variables M2_REPO choose all and click in Next) 

to build project :

mvn clean install 
or you can use maven on Eclipse

The class SolutionClimbingStairsTest execute 3 tests according 
3 examples in expecification Technical Task Outline

To run to tests:

add project on Tomcat 

Start Tomcat and access URL:

http://localhost:8080/ClimbingStairs/

Was developed validations input that don't allow invalid data.

