package SQLConstructor;

/**
 This Document explains the purpose of the SQLConstructor Class. This package is used
 in both the Client and the Servlet side. The SQLConstructor Package is used to organize the request information into a java class so
 that it can be packaged and unpacked easily into JSON format. The Request and Response across
 the servlet will all be in JSON format.

 For Client:
 1) Construct an object of SQLConstructor class
 2) Use gson.toJson(SQLConstructorobject)
 3) send jsonString to servlet

 For Servlet:
 1) Receive request in JSON format
 2) use gson.fromJson(Request, SQLConstructorobject.class)
 3) execute the SQL constructed based on the object (using .execute method)
 3) Output the information returned by the SQL into a ResultSet object

 **/