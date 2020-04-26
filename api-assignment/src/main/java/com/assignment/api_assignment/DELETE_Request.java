package com.assignment.api_assignment;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.assignment.utility.*;

public class DELETE_Request {

	/**
	 * This method used to delete the Employee details
	 * from the server for executing DELETE operation 
	 * 
	 */
	@Test(priority=1)
	public void deleteEmployeePostiveFlow() {
		
		try {
			
			// This line used to get the base URL for DELETE
			RestAssured.baseURI = Constants.DeleteBaseURL;
			
			// Define the specification of request
			RequestSpecification httpRequest = RestAssured.given();
			
			//Makes calls to the server using Method type
			Response response = httpRequest.request(Method.DELETE);
			
			//Get the status code from response
			int statusCode = response.getStatusCode();
			System.out.println("The Status Code is :");
			System.out.println(statusCode);
			Assert.assertEquals(statusCode, 200);
			//Get the response body data print on console
			String responseData = response.asString();
			System.out.println("The Response JSON schema is: "); 
			System.out.println(responseData);
			
		} catch (Exception ex) {
			System.out.println("Error! Not able to delete record" +ex.getMessage());
		}
	}
	
	/**
	 * This method used to delete the non-existing employee
	 * from the server for executing DELETE operation 
	 * 
	 */
	
	@Test(priority=2)
	public void deleteEmployeeNegativeFlow() {
		
		try {
			// This line used to get the base URL for DELETE
			RestAssured.baseURI = Constants.DeleteNegativeFlow;
			
			// Define the specification of request
			RequestSpecification httpRequest = RestAssured.given();
			
			//Makes calls to the server using Method type.
			Response response = httpRequest.request(Method.DELETE);
			
			//Get the response body data print on console
			String responseData = response.asString();
			System.out.println("The Response JSON schema is: "); 
			System.out.println(responseData);
		} 
		catch (Exception ex) {
			System.out.println("Error! Not able to delete record" +ex.getMessage());
		}
	}
}
