package TestClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.HttpURLConnection;

import org.json.simple.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import Links.FilesPaths;
import Links.URLs;
import Utils.JSONUtils;
import enums.HTTPMethod;
import enums.HTTPRequestsContentTypes;
import requestHandling.RestClientHandler;

public class TestPutAPI {
	
	 
	@Test
	public void testUpdateUser() throws Exception {

		String url = URLs.ReqResAPI+"/2";
		
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.PUT,
				HTTPRequestsContentTypes.JSON);

		String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.UpdateUserJSONFile);
		
		System.out.println(resquestJSONObject);
		


		RestClientHandler.sendPut(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);

		System.out.println(connection.getResponseCode());
		String response = RestClientHandler.readResponse(connection);
		System.out.println(response);
		
		assertTrue("unable to connect to webservice", connection.getResponseCode() == 200);
		
		
	
		

		
	}
	
}
