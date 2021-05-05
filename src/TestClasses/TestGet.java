package TestClasses;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.junit.Ignore;
import org.junit.Test;

import Links.FilesPaths;
import Links.URLs;
import Utils.JSONUtils;
import enums.HTTPMethod;
import enums.HTTPRequestsContentTypes;
import requestHandling.HandleRequestReponse;
import requestHandling.RestClientHandler;

public class TestGet {

	@Test
	public void Testgetlistusers() throws IOException, ParseException {

		HttpURLConnection connection = RestClientHandler.connectServer(URLs.ReqResAPIListUsers, HTTPMethod.GET,
				HTTPRequestsContentTypes.JSON);
		// 2. validate if the connection is successfully openned
		System.out.println("connection.getResponseCode() : " + connection.getResponseCode());
		assertTrue("unable to connect to webservice", connection.getResponseCode() == 200);
		// 3. reading response using input stream
		String response = RestClientHandler.readResponse(connection);
		System.out.println(response);
		assertNotNull(response);

		System.out.println(response.getClass().getName());
		JSONObject jsonObject = (JSONObject) JSONUtils.convertStringToJSON(response);
		String data = jsonObject.get("data").toString();
		System.out.println("data=" + data);

	

	}
	@Test
	public void TestgetSingelUser() throws Exception {

		String url = URLs.ReqResAPI+"/2";
		System.out.println(url);		
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.GET,
				HTTPRequestsContentTypes.JSON);
		
		String response = RestClientHandler.readResponse(connection);
		System.out.println(response);

		JSONObject jsonObject = (JSONObject) JSONUtils.convertStringToJSON(response);
		System.out.println(jsonObject);
		String data = jsonObject.get("data").toString();
		System.out.println("data=" + data);
		String firstName = ((JSONObject) jsonObject.get("data")).get("first_name").toString();
		System.out.println("first name=" + firstName);	
		String supportText ="To keep ReqRes free, contributions towards server costs are appreciated!";
		String supportTextAPI =((JSONObject) jsonObject.get("support")).get("text").toString();
		System.out.println("support Text of API= " + supportTextAPI);
		supportText.equals(supportTextAPI);
		
		


	}
	
	@Test 
	public void TestsingleUserNotFound() throws Exception {

		String url = URLs.ReqResAPI+"/24";
		System.out.println(url);		
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.GET,
				HTTPRequestsContentTypes.JSON);		
		System.out.println("connection.getResponseCode() : " + connection.getResponseCode());
		assertTrue(connection.getResponseCode() == 404);

		
	}
	
	
	@Test 
	public void TestDelay() throws Exception {

		String url = URLs.ReqResAPIDelay;
		System.out.println(url);
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.GET,
		HTTPRequestsContentTypes.JSON);
	
		String response = RestClientHandler.readResponse(connection);
		System.out.println(response);

		JSONObject jsonObject = (JSONObject) JSONUtils.convertStringToJSON(response);
		System.out.println(jsonObject);
		String total = jsonObject.get("total").toString();
		System.out.println("total=" + total);		
	}

}
