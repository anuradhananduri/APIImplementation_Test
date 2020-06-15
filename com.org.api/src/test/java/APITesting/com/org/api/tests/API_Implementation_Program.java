package APITesting.com.org.api.tests;

import java.util.Scanner;
import com.jayway.restassured.response.Response;
import APITesting.com.org.api.ByCountryCode;
import APITesting.com.org.api.ByCountryName;

public class API_Implementation_Program {	

	public static void main(String args[]) {

		String countryParm =  null;
		String countryCode =  null;
		String countryName =  null;
		String userChoice=null;
		ByCountryCode byCountryCode = new ByCountryCode();
		ByCountryName byCountryName = new ByCountryName();
		Scanner scan = new Scanner(System.in);

		try {
			do {
				//User has to choose to test with Country 'code' or 'name'
				System.out.println("Want to test with Country's 'code' or 'name':");
				countryParm = scan.nextLine();

				if(countryParm.equals("code")) {

					//User has to enter the Country code as input to API call
					System.out.println("Enter Country code:");
					countryCode = scan.nextLine();
					Response resp = byCountryCode.getRequest(countryCode);
					System.out.println("Capital of the Country:" + byCountryCode.getCapital(resp));
				}
				else if(countryParm.equals("name")){

					//User has to enter the Country name as input to API call
					System.out.println("Enter Country name:");
					countryName = scan.nextLine();
					Response resp = byCountryName.getRequest(countryName);	
					System.out.println("Capital of the Country:" + byCountryName.getCapital(resp));
				}

				//User can choose to continue or exit
				System.out.println("Enter 'continue' or 'exit':");
				userChoice = scan.nextLine();	

			} while(userChoice.equals("continue"));
		}
		catch(Exception e)
		{
			//When an invalid input is given to the API
			System.out.println("Please enter valid " + countryParm);
		}
		System.out.println("Thank you for testing!");

		scan.close();

	}

}
