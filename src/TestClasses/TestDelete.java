package TestClasses;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import Links.FilesPaths;
import Links.URLs;
import Utils.JSONUtils;
import enums.HTTPMethod;
import enums.HTTPRequestsContentTypes;
import requestHandling.RestClientHandler;

public class TestDelete {
	
	@Test
	public void TestRestClientHandler() throws Exception {

	String url = URLs.ReqResAPI+"/2";
	
	HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.DELETE,
			HTTPRequestsContentTypes.JSON);

	String resquestJSONObject = JSONUtils.readJSONObjectFromFile(FilesPaths.DeleteUserJSONFile);
	System.out.println(resquestJSONObject);
	RestClientHandler.sendDelete(connection, resquestJSONObject, HTTPRequestsContentTypes.JSON);
	System.out.println(connection.getResponseCode());
	String response = RestClientHandler.readResponse(connection);
	System.out.println("{"+response+"}");
	assertTrue( connection.getResponseCode() == 204);
	


}
}
