# **BLOG**
The main aim of this blog is to create a web application implementing a platform to publish and manage a users content.

## **Current Working**
A user can register into the database using a RegisterService layer in java.
We can test it using TestRegisterService available at /BLOG-core/src/test/java/com/aynna/service/TestRegisterService.java.
It works currently with a remote cloud database with the configuration in ConnectionUtil class. Feel free to view the sql querries also in the reppo. You might just want to execte only the CREATIONS.sql as the others querries containing PROCEDURES and FUNCTIONS were implemented using dao in java so not necessary.

It will validate for valid user and will either throw exception or will add the user to database depending on its validation.

I have assumed that the emailid is unique.

A web page has been added for a user to log in, register and post. Any one can vew all posts by any user.
can add tags as much as they want.
