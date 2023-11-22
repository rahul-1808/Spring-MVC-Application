Java Project

Description-
This project is a Spring MVC appliation which uses lombok, springweb, Thymeleaf and it has 4 fields which are validated on server side 
and it saves the data in a database which can be accessed , we can check the usercount in the database 
and filter a user by its First Name.

How to run-
This project is made in eclipse and you need to run the project in eclipse 
for that you need to first import the project in your eclipse and run the c0836335ProjectApplication.java file
to start the application.

Details of the project-
This project has 7 class files out of which 1 is the main file which we run (c0836335ProjectApplication.java)
1 interface
1 unit test file
1 xml file (pom.xml)
3 html files

There are 4 fields (First Name, Last Name, Email, Age ) which are defined in UserClass.java file.
The form is validated on server side for every field I used @NotNull, @NotBlank, @Size, @Email, @Positive,@Digits for validation which is defined in UserClass.java file.
@Valid, @Model.Attribute in UserController.java helps to validate the data on server side .
The RDS connection information is stored in the Application properties spring.jpa.hibernate is set to update so that it updates everytime when the user enters data.
UserController.java uses the Thymeleaf which is done with the help of model.
The Interface UserRepository.java has the method to filter the list by First Name.
The @GetMapping method in UserRestController.java is used to return the usercount.
There is an Api which runs asynchronously and displays the usercount on everypage
which refreshes every 3 seconds and is applied in all the html pages in the script tags.
@AutoWired is used to inject the same dependency in UserController.java and UserRestController.java.
UserClass.java has used Lombok for @Data @NoArgsConstructior @AllArgsConstructor.
The three webpages are userform.html where the user fills the data , saved.html which is displayed when the data
filled by user is accepted and listusers.html which displays all the data which is recorded in the database in tabular form.
All the webpages have CSS so that the website looks appealing and aesthetic.
The unit tests are done in UserControllerTests.java