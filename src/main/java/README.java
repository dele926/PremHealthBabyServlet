/**
  This is a Java HTTPServlet which processes requests from an Android Client to a SQL database. It is 
  created for a 2020 Programming Project at Imperial College London where the students make an Android application to display
  blood metabolite values of premature babies for the purpose of health monitoring.
  
  The Servlet takes in a JSON format request, reads whether the client wants to "edit" or "view", other relevant parameters,
  constructs an appropriate SQLQuery which is sent to an online SQL Database (hosted using Amazon AWS) containing all patient information
  and then sends the retrieved data back to the client in JSON format.
  
  Get and Post methods were constructed according to REST principles. DoGet exclusively processes "view" requests, whereas doPost processes
  both "View and Edit" methods.
  
  Two packages of classes were defined:
  One is "SQLConstructor:, which is responsible for reading in the request, constructing the appropriate SQL, and storing the retrieved data.
  The other is "ReturnObjects", which is used to filter and store the retrieved data into ArrayLists using HashMap. The ReturnObject is then
  used to construct the JSON string which is sent back to the client.
  
  We hope you enjoy this project! Keep babies healthy!
  
  **/
