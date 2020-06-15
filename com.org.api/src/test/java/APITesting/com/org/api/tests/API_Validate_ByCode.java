package APITesting.com.org.api.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;
import APITesting.com.org.api.ByCountryCode;

public class API_Validate_ByCode {


	@DataProvider (name= "Valid Country Code and Capitals")
	public Object[][] createData() {
		return new Object[][] {
			{"IN","New Delhi"},
			{"US","Washington, D.C."}
		};		 
	}
	
	@DataProvider (name= "Valid Country Code")
	public Object[] createDataForStatusCode() {
		return new Object[] {
			"IN",
			"US"
		};		 
	}

	@DataProvider (name= "Invalid country code")
	public Object[] createInvalidData() {
		return new Object[] {
				"xy",
				"zx",
				"1d",
				"65"
		};		 
	}

	@DataProvider (name= "No country code")
	public Object[] createNullData() {
		return new Object[] {
				" ",		   
		};		 
	}

	//Validate Success Status Code of the response
	@Test (dataProvider = "Valid Country Code")
	public void successStatusCode(String code) {		
		ByCountryCode byCountryCode = new ByCountryCode();
		Response resp = byCountryCode.getRequest(code);
		int statusCode = byCountryCode.getStatusCode(resp);
		Assert.assertEquals(statusCode, 200);		
	}

	//Validate Status Code of the response when invalid input is given
	@Test (dataProvider = "Invalid country code")
	public void failureStatusCode(String code) {		
		ByCountryCode byCountryCode = new ByCountryCode();
		Response resp = byCountryCode.getRequest(code);
		int statusCode = byCountryCode.getStatusCode(resp);
		Assert.assertEquals(statusCode, 404);		
	}

	//Validate Status Code of the response when Blank input is given
	@Test (dataProvider = "No country code")
	public void failStatusCode(String code) {		
		ByCountryCode byCountryCode = new ByCountryCode();
		Response resp = byCountryCode.getRequest(code);
		int statusCode = byCountryCode.getStatusCode(resp);
		Assert.assertEquals(statusCode, 400);		
	}

	//Validate Expected Capital in the response
	@Test (dataProvider = "Valid Country Code and Capitals")
	public void validateCapital(String code, String expectedCapital) {		
		ByCountryCode byCountryCode = new ByCountryCode();
		Response resp = byCountryCode.getRequest(code);
		String actualCapital = byCountryCode.getCapital(resp);
		Assert.assertEquals(actualCapital, expectedCapital);		
	}

	//Validate the response when invalid input is given
	@Test (dataProvider = "Invalid country code")
	public void failureCapital(String code) {		
		ByCountryCode byCountryCode = new ByCountryCode();
		Response resp = byCountryCode.getRequest(code);
		String actualCapital = byCountryCode.getCapital(resp);
		Assert.assertEquals(actualCapital, null);		
	}

}
