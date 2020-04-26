package com.assignment.api_assignment;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.assignment.utility.*;
public class POST_Request {

	/**
	 * This method used to Create new Employee details
	 * to the server for performing POST call
	 * 
	 */
	@Test
	public void postEmployeePostiveFlow() {
		
		try {
			// This line used to get the base URL for POST
			RestAssured.baseURI = Constants.PostBaseURL;
			
			// Define the specification of request
			RequestSpecification httpRequest = RestAssured.given();
			
			//Define content type to header
			httpRequest.header("Content-Type", "application/json");

			//Create JSON object
			JSONObject json = new JSONObject();
			json.put("name", "test");
			json.put("salary", "123");
			json.put("age", "26");
			
			//Adding JSON body as string to the HttpRequest
			httpRequest.body(json.toJSONString());
			
			//Makes calls to the server using Method type.
			Response response = httpRequest.request(Method.POST);
			
			//Get the status code from response
			int statusCode = response.getStatusCode();
			System.out.println("The Status Code is :"+statusCode);
			
			//Validate the response code with value 200
			Assert.assertEquals(statusCode, 200);
			
			//Get the response body data print on console
			String responseData = response.asString();
			System.out.println("The Response JSON schema is:  " + responseData);
		} 
		catch (Exception ex) {
			
			System.out.println("Oops! someting issue found to post the requested record to the server" +ex.getMessage());
		}
	}
}
