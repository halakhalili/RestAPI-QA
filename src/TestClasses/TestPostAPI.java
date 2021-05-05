package TestClasses;

import static org.junit.Assert.assertTrue;

import java.net.HttpURLConnection;

import org.junit.Test;

import Links.FilesPaths;
import Links.URLs;
import Utils.JSONUtils;
import enums.HTTPMethod;
import enums.HTTPRequestsContentTypes;
import requestHandling.RestClientHandler;

public class TestPostAPI {
	
	
	@Test
	public void testCreate() throws Exception {

		String url = URLs.ReqResAPI;
		
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.POST,
				HTTPRequestsContentTypes.JSON);
		
		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.CreateUserJSONFile);
		System.out.println(resquestJSONObject);

		
		RestClientHandler.sendPost(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
	
		System.out.println(connection.getResponseCode());
		String response = RestClientHandler.readResponse(connection);
		System.out.println(response);
		assertTrue( connection.getResponseCode() == 201);		
	}
	
	@Test
	public void testregisterSuccessful() throws Exception {

		
		String url = URLs.ReqResAPIregister;
		
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.POST,
				HTTPRequestsContentTypes.JSON);

		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.registerSuccessfulJSONFile);
		System.out.println(resquestJSONObject);

		
		RestClientHandler.sendPost(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);

		System.out.println(connection.getResponseCode());
		String response = RestClientHandler.readResponse(connection);
		System.out.println(response);
		assertTrue( connection.getResponseCode() == 200);		
	}
	
	
	
	
	@Test
	public void testregisterUnSuccessful() throws Exception {

		String url = URLs.ReqResAPIregister;
		
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.POST,
				HTTPRequestsContentTypes.JSON);
		
		System.out.println(FilesPaths.registerUnSuccessfulJSONFile);

		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.registerUnSuccessfulJSONFile);
		System.out.println(resquestJSONObject);

		RestClientHandler.sendPost(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
		System.out.println(connection.getResponseCode());
		assertTrue( connection.getResponseCode() == 400);		
	}
	
	
	
	@Test
	public void testLoginSuccessful() throws Exception {

		String url = URLs.ReqResAPIlogin;
		
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.POST,
				HTTPRequestsContentTypes.JSON);
		

		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.loginSuccessfulJSONFile);
		System.out.println(resquestJSONObject);

		
		RestClientHandler.sendPost(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
		System.out.println(connection.getResponseCode());
		assertTrue( connection.getResponseCode() == 200);		
	}
	
	
	
	@Test
	public void testLoginUnSuccessful() throws Exception {

		String url = URLs.ReqResAPIlogin;
		
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.POST,
				HTTPRequestsContentTypes.JSON);
		

		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.loginUnSuccessfulJSONFile);

		
		RestClientHandler.sendPost(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
		System.out.println(connection.getResponseCode());
		assertTrue( connection.getResponseCode() == 400);
	}
	
	
}
