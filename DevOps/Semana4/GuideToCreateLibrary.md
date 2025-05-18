# 1. Generate the new project with maven
## 1.1 Please refer to guide to CreateMavenProject if needed
/shell
mvn archetype:generate

# 2. Change to the directory of the project
/shell
cd project

# 3. Clean the project
## 3.1 Remove from the package the App.java and the test folder

# 4. Create a java class with your preferrable name with the necessary code

# 5. Run the following command in the project folder to package the application and install in the local repository (~/.m2)
## 5.1 Check for the build phases. Each plugin is responsible for each phase
/shell
mvn install

# 6. After that change to another project to start using the new library

# 7. In the pom.xml add the new dependency in dependencies part
/xml
<dependency>
    <groupId>group.name</groupId>
    <artifactId>projectName</artifactId>
    <version>projectVersion</version>
</dependency>

# 8. In the java project now you can instantiate a object of the type of the library

