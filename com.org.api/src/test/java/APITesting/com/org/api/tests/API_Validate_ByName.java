package APITesting.com.org.api.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;
import APITesting.com.org.api.ByCountryName;

public class API_Validate_ByName {

	@DataProvider (name= "Valid Country Name and Capitals")
	public Object[][] createData() {
		return new Object[][] {
			{"IN","New Delhi"},
			{"US","Washington, D.C."}
		};		 
	}
	
	@DataProvider (name= "Valid Country Name")
	public Object[] createDataForStatusCode() {
		return new Object[] {
			"IN",
			"US"
		};		 
	}

	@DataProvider (name= "Invalid country name")
	public Object[] createInvalidData() {
		return new Object[] {
				"xy",
				"zx",
				"1d",
				"65"
		};		 
	}

	@DataProvider (name= "No country name")
	public Object[] createNullData() {
		return new Object[] {
				" ",		   
		};		 
	}

	//Validate Success Status Code of the response
	@Test (dataProvider = "Valid Country Name")
	public void successStatusCode(String name) {		
		ByCountryName byCountryName = new ByCountryName();
		Response resp = byCountryName.getRequest(name);
		int statusCode = byCountryName.getStatusCode(resp);
		Assert.assertEquals(statusCode, 200);		
	}

	//Validate Status Code of the response when invalid input is given
	@Test (dataProvider = "Invalid country name")
	public void failureStatusCode(String name) {		
		ByCountryName byCountryName = new ByCountryName();
		Response resp = byCountryName.getRequest(name);
		int statusCode = byCountryName.getStatusCode(resp);
		Assert.assertEquals(statusCode, 404);		
	}

	//Validate Status Code of the response when Blank input is given
	@Test (dataProvider = "No country name")
	public void failStatusCode(String name) {		
		ByCountryName byCountryName = new ByCountryName();
		Response resp = byCountryName.getRequest(name);
		int statusCode = byCountryName.getStatusCode(resp);
		Assert.assertEquals(statusCode, 400);		
	}

	//Validate Expected Capital in the response
	@Test (dataProvider = "Valid Country Name and Capitals")
	public void validateCapital(String name, String expectedCapital) {		
		ByCountryName byCountryName = new ByCountryName();
		Response resp = byCountryName.getRequest(name);
		String actualCapital = byCountryName.getCapital(resp);
		Assert.assertEquals(actualCapital, expectedCapital);		
	}

	//Validate the response when invalid input is given
	@Test (dataProvider = "Invalid country name")
	public void failureCapital(String name) {		
		ByCountryName byCountryName = new ByCountryName();
		Response resp = byCountryName.getRequest(name);		
		String actualCapital = byCountryName.getCapital(resp);		
		Assert.assertEquals(actualCapital, "Invalid Input");		
	}

}

