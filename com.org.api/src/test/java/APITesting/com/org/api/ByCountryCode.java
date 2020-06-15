package APITesting.com.org.api;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;


import static com.jayway.restassured.RestAssured.*;

public class ByCountryCode {
	
	public static String URI=null;
	
	public ByCountryCode(){
	URI = "https://restcountries.eu/rest/v2/alpha/";
	}
	
	public Response getRequest(String countryCode) {
		Response resp = when().get(URI + countryCode);
		return resp;		
	}
	
	public int getStatusCode(Response resp) {
		return resp.getStatusCode();
	}
	
	public String getCapital(Response resp) {
		String capital = resp.
				then().
				contentType(ContentType.JSON).
				extract().
				path("capital");
		return capital;				
	}
	
	public String getContentType(Response resp) {
							
		return resp.header("Content-Type");
	}

}
