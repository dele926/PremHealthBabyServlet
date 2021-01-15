package SQLConstructor;

/**
 This Document explains the Design Process behind the class structure of the SQLConstructor
 Package

 The SQLConstructor Package is used to construct Client Request Messages.
 Its goal is to organize the request information into a javascript object so that
 1) it can be sent in a JSON format (using GSON library) across the HTTPServer
 2) be successfully unpacked and turned into a SQLQuery that is sent to the Postgresql database
 3) organize retrieved information

 Structure of Our Program
 We have several different SQL Queries that we want to perform
 They can be grouped by function into:
 1) Edit - using "UPDATE" and existing in doPost Method
 2) View - using "SELECT" and existing in doGet Method

 These SQL Queries further differ by the information they need to construct the SQL
 These information are specific to the type of Client accessing them:
 Clinician
 i) Edit - comments
 ii) View - everything but filter method
 Engineer
 i) Edit - filter method
 ii) View1 - everything for 1 person
 iii) View2 - everything for the database
 Physician
 i) Edit - prescription
 ii) View - everything except for filter method

 To do this: We will use implementations:
 Viewable
 Getable

 and have classes
 Clinician
 Engineer
 Physician


 This means when the Client sends us information, they need to enter all information depending
 on the user type

 So they will be sending me a "Clinician" Object

 Say they sent me a "Clinician" Object, how will I unpack this?

 Each time they will only send me a Client Object but won't tell me what to do with it
 which defeats the purpose?

 I shouldn't be the one saying Clinician.view()
So it will be something like I keep waiting for them to send me what command they want
 then i do "view"? That doesnt make the most sense to me. I think all SQLQueries should
 be their own objects.




 **/