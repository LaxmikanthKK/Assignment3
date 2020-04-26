package com.assignment.api_assignment;

import org.apache.http.HttpRequest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import com.assignment.utility.*;

public class GET_Request {

	/**
	 * This method used to GET the Employee details
	 * from the respected URL for performing API testing
	 * 
	 */
	
	@Test(priority=1)
	public void getEmployeePositiveFlow() {

		try {
			// This line used to get the base URL for GET
			RestAssured.baseURI= Constants.GetBaseURL;

			// Define the specification of request
			RequestSpecification httpRequest = RestAssured.given();

			//Makes calls to the server using Method type.
			Response response = httpRequest.request(Method.GET);

			//Get the status code from response
			int statusCode = response.getStatusCode();
			System.out.println("The Status Code is : ");
			System.out.println(statusCode);
			
			//Validate the response code with value 200
			Assert.assertEquals(statusCode, 200);
			
			//Get the response body data print on console
			String responseData = response.asString();
			System.out.println("The Response JSON schema is:  ");
			System.out.println(responseData);
			
		} catch (Exception ex) {
			
			System.out.println("Oops! someting issue found to fetch record" +ex.getMessage());
		}
	}
	
	/**
	 * This method used to GET the Employee details
	 * of non existing users for negative flow
	 * from the respected URL for performing API testing
	 * 
	 */
	@Test(priority=2)
	public void getEmployeeNegativeFlow() {

		try {
			// This line used to get the base url for GET
			RestAssured.baseURI= Constants.GetNegativeFlow;

			// Define the specification of request
			RequestSpecification httpRequest = RestAssured.given();

			// Makes calls to the server using Method type.
			Response response = httpRequest.request(Method.GET);

			// Get the status code from response
			int statusCode = response.getStatusCode();
			System.out.println("The Status Code is : ");
			System.out.println(statusCode);
			
			//Get the response body data
			String responseData = response.asString();
			System.out.println("The Response JSON schema is:   ");
			System.out.println(responseData);
		} 
		catch (Exception ex) {
			
			System.out.println("Oops! someting issue found to fetch record" +ex.getMessage());
		}
	}
	}
