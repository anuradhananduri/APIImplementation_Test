package APITesting.com.org.api;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class ByCountryName {

	public static String URI = null;
	
	public ByCountryName() {
	URI = "https://restcountries.eu/rest/v2/name/";
	}
	
	public Response getRequest(String countryName) {
		Response resp = given().
						parameter("fullText",true).
						when().
						get(URI + countryName);
		return resp;		
	}
	
	public int getStatusCode(Response resp) {
		return resp.getStatusCode();
	}
	
	public String getCapital(Response resp) {
		
		try {
		String capital = resp.
						then().
						contentType(ContentType.JSON).
						extract().
						path("[0].capital");
		return capital;	
		}
		catch(Exception ex) {
			return "Invalid Input";
		}
	}
	
	public String getContentType(Response resp) {
		
		return resp.header("Content-Type");
	}
}
