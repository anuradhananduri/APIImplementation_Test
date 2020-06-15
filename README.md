# APIImplementation_Test

- Used Maven project to implement this task.
- All the dependencies added are in pom.xml file. 
- TestNg framework is used for writing test methods. 
- TestNg.xml is used to run the testNg suite.
- All the code related to this task is in the following path : src/test/java/APITesting/com/org/api
- The program in the path : /com.org.api/src/test/java/APITesting/com/org/api/tests/ Name : API_Implementation_Program.java is used to call the API to retrieve the Capital based on the the input provided in the console. 
- Enter code to provide codes as input and name to provide name as input. If valid code or name is provided the REST API is called and the capital is retreived.
- The code will exit only when the user either chooses to exit or provides an invalid input
- If incorrect code or name is provided then error message is returned - Invalid code or name.
- The program - API_Validate_ByCode.java is used to validate the API based on code.
- The program - API_Validate_ByName.java is used to validate the API based on the name.
- The program - API_Validate_ResponseType_JSON.java is used to validate the API's response content type but should be run through the TestNg Suite as the inputs are passed as parameters in the TestNg.xml file.
