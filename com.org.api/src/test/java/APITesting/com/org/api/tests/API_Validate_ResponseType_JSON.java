package APITesting.com.org.api.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;
import APITesting.com.org.api.ByCountryCode;
import APITesting.com.org.api.ByCountryName;

public class API_Validate_ResponseType_JSON {

	//Validate Response Type to be JSON in ByCode API
	@Parameters({ "country-code" })
	@Test 
	public void validateResponseContentType_ByCode(String code) {		
		ByCountryCode byCountryCode = new ByCountryCode();
		Response resp = byCountryCode.getRequest(code);
		String contentType = byCountryCode.getContentType(resp);
		Assert. assertTrue(contentType.contains("json"));

	}

	//Validate Response Type to be JSON in ByName API
	@Parameters({ "country-name" })
	@Test 
	public void validateResponseContentType_ByName(String name) {		
		ByCountryName byCountryName = new ByCountryName();
		Response resp = byCountryName.getRequest(name);
		String contentType = byCountryName.getContentType(resp);
		Assert. assertTrue(contentType.contains("json"));
	}

}
