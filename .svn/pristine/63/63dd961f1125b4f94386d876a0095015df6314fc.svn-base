package edu.ben.servlets;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class Sample {

	public static void main(String[] args)  {
//		System.out.println(validAddress("1741 S Lalonde Ave", "Lombard", "IL", "60148"));
//		try {
//			System.out.println("soap");
//			validAddress2(); // post with soap protocol
//			System.out.println("rest");
//			validAddressREST_Postman(); // post with rest protocol
//			// both use okhttpclient
//		} catch (Exception e) {
//			System.out.println(false);
//		}
		
		
		boolean valid = validateAddress("21 Venard Ct", "Lombard", "Illinois", "60148");
		System.out.println("valid address = " + valid);
	}
	
	private static boolean validateAddress(String street, String city, String state, String zip) {
		boolean flag = true;
		
		try {
			JSONObject streetAddr = validateStreet(street,city, state, zip);
			
			String stateCode = streetAddr.getString("PoliticalDivision1");
			JSONObject cityVal = validateCityStateZip(city, stateCode, zip);
			
			String cityResponse1 = streetAddr.getString("PoliticalDivision2");
			String stateResponse1 = streetAddr.getString("PoliticalDivision1");
			String zipResponse1 = streetAddr.getString("PostcodePrimaryLow");
			
			String cityResponse2 = cityVal.getString("city");
			String stateResponse2 = cityVal.getString("state");
			String zipResponse2 = cityVal.getString("zip");
			
			// check equality for city, zip, state codes
			if (!cityResponse1.equals(cityResponse2) && !stateResponse1.equals(stateResponse2) 
				&& !zipResponse1.equals(zipResponse2)) {
				flag = false;
			}
			
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}
	
	private static JSONObject validateStreet(String street, String city, String state, String zip) throws Exception {
		// xav response, street validation

		OkHttpClient client = new OkHttpClient();
		
//		String city = "Lombard";
		city = "\"" + city + "\"";
		
//		String state = "Illinois";
		state = "\"" + state + "\"";
		
//		String zip = "60148";
		zip = "\"" + zip + "\"";
		
//		String street = "1741 S Lalonde Ave";
		street = "\"" + street + "\"";
		
		// RequestBody b2 = new RequestBody.create("application/json");

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType,
				"{\r\n\t\"UPSSecurity\": {\r\n\t\t\"UsernameToken\": {\r\n\t\t\t\"Username\": "
				+ "\"attarsaaniya\",\r\n\t\t\t\"Password\": "
				+ "\"Summer2017\"\r\n\t\t},\r\n\t\t\"ServiceAccessToken\": "
				+ "{\r\n\t\t\t\"AccessLicenseNumber\": "
				+ "\"DD33B9ADDD7ADDC8\"\r\n\t\t}\r\n\t},"
				+ "\r\n\t\"XAVRequest\": {\r\n\t\t\"Request\": "
				+ "{\r\n\t\t\t\"RequestOption\": \"1\",\r\n\t\t\t"
				+ "\"TransactionReference\": {\r\n\t\t\t\t\"CustomerContext\":"
				+ " \"Your Customer Context\"\r\n\t\t\t}\r\n\t\t},\r\n\t\t"
				+ "\"MaximumListSize\": \"10\",\r\n\t\t\"AddressKeyFormat\": "
				+ "{\r\n\t\t\t\"ConsigneeName\": \"Consignee Name\",\r\n\t\t\t"
				+ "\"BuildingName\": \"Building Name\",\r\n\t\t\t\"AddressLine\": "
				+ street + ",\r\n\t\t\t\"PoliticalDivision2\": "
				+ city + ",\r\n\t\t\t\"PoliticalDivision1\": "
				+ state + " ,\r\n\t\t\t\"PostcodePrimaryLow\":"
				+ zip + ",\r\n\t\t\t\"CountryCode\": \"US\"\r\n\t\t}\r\n\t}\r\n}");
		
		Request request = new Request.Builder().url("https://onlinetools.ups.com/rest/XAV").post(body).build();

		okhttp3.Response response = client.newCall(request).execute();

		JSONObject jResponse = new JSONObject(response.body().string());
		System.out.println(jResponse);

		JSONObject xavResponse = jResponse.getJSONObject("XAVResponse");
		JSONObject response5 = xavResponse.getJSONObject("Response");
		JSONObject respStatus = response5.getJSONObject("ResponseStatus");
		String desc = respStatus.getString("Description");
		
		// check desc == "Success"
		// check if this matches city/state/zip from other api

		System.out.println(desc);
		JSONObject candidate = xavResponse.getJSONObject("Candidate");
		JSONObject addrKeyFormat = candidate.getJSONObject("AddressKeyFormat");
		String addrResponse = addrKeyFormat.getString("AddressLine");
		String cityResponse = addrKeyFormat.getString("PoliticalDivision2");
		String stateResponse = addrKeyFormat.getString("PoliticalDivision1");
		String zipResponse = addrKeyFormat.getString("PostcodePrimaryLow");
		
		System.out.println(addrResponse);
		System.out.println(cityResponse);
		System.out.println(stateResponse);
		System.out.println(zipResponse);

		return addrKeyFormat;
	}
	
	private static JSONObject validateCityStateZip(String city, String state, String zip) throws Exception {
		OkHttpClient client = new OkHttpClient();

//		String city = "Lombard";
		city = "\"" + city + "\"";
		
//		String state = "IL";
		state = "\"" + state + "\"";
		
//		String zip = "60148";
		zip = "\"" + zip + "\"";
		
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType,
				"{\r\n\t\"AccessRequest\": {\r\n\t\t\"UserId\": \"attarsaaniya\",\r\n\t\t\"AccessLicenseNumber\": "
				+ "\"DD33B9ADDD7ADDC8\",\r\n\t\t"
				+ "\"Password\": \"Summer2017\"\r\n\t},\r\n\t\"AddressValidationRequest\": "
				+ "{\r\n\t\t\"Address\": {\r\n\t\t\t\"StateProvinceCode\": " + state + ",\r\n\t\t\t"
				+ "\"PostalCode\": " + zip + ",\r\n\t\t\t\"City\": " + city +  "\r\n\t\t},\r\n\t\t"
				+ "\"Request\": {\r\n\t\t\t\"TransactionReference\": {\r\n\t\t\t\t\"CustomerContext\": "
				+ "\"mycustomer\"\r\n\t\t\t},\r\n\t\t\t\"RequestAction\": \"AV\"\r\n\t\t}\r\n\t}\r\n}");
		
		Request request = new Request.Builder().url("https://wwwcie.ups.com/rest/AV").post(body).build();

		okhttp3.Response response = client.newCall(request).execute();
		JSONObject jResp = new JSONObject(response.body().string());
		System.out.println(jResp);
		
		// there shoudl be a better way to parse through the tree tbh
		// but this seems intuitive enough to do (though so extra) 
		JSONObject addrValResp = jResp.getJSONObject("AddressValidationResponse");
		JSONObject addrVal = addrValResp.getJSONObject("AddressValidationResult");
		JSONObject addr = addrVal.getJSONObject("Address");
		
		String cityResponse = addr.getString("City");
		String stateResponse = addr.getString("StateProvinceCode");
		String zipResponse = addrVal.getString("PostalCodeLowEnd");
		
		JSONObject cityStateZip = new JSONObject();
		cityStateZip.put("city", cityResponse);
		cityStateZip.put("state", stateResponse);
		cityStateZip.put("zip", zipResponse);
		
		System.out.println(cityResponse);
		System.out.println(stateResponse);
		System.out.println(zipResponse);
//		String success = addrVal
	
		return cityStateZip;
	}

	private static boolean validAddressREST_Postman() throws JSONException, IOException {

		
		// city state zip only
		OkHttpClient client = new OkHttpClient();

		String city = "Lombard";
		city = "\"" + city + "\"";
		
		String state = "IL";
		state = "\"" + state + "\"";
		
		String zip = "60148";
		zip = "\"" + zip + "\"";
		
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType,
				"{\r\n\t\"AccessRequest\": {\r\n\t\t\"UserId\": \"attarsaaniya\",\r\n\t\t\"AccessLicenseNumber\": "
				+ "\"DD33B9ADDD7ADDC8\",\r\n\t\t"
				+ "\"Password\": \"Summer2017\"\r\n\t},\r\n\t\"AddressValidationRequest\": "
				+ "{\r\n\t\t\"Address\": {\r\n\t\t\t\"StateProvinceCode\": " + state + ",\r\n\t\t\t"
				+ "\"PostalCode\": " + zip + ",\r\n\t\t\t\"City\": " + city +  "\r\n\t\t},\r\n\t\t"
				+ "\"Request\": {\r\n\t\t\t\"TransactionReference\": {\r\n\t\t\t\t\"CustomerContext\": "
				+ "\"mycustomer\"\r\n\t\t\t},\r\n\t\t\t\"RequestAction\": \"AV\"\r\n\t\t}\r\n\t}\r\n}");
		
		Request request = new Request.Builder().url("https://wwwcie.ups.com/rest/AV").post(body).build();

		okhttp3.Response response = client.newCall(request).execute();
		JSONObject jResp = new JSONObject(response.body().string());
		System.out.println(jResp);
		
		// there shoudl be a better way to parse through the tree tbh
		// but this seems intuitive enough to do (though so extra) 
		JSONObject addrValResp = jResp.getJSONObject("AddressValidationResponse");
		JSONObject addrVal = addrValResp.getJSONObject("AddressValidationResult");
		JSONObject addr = addrVal.getJSONObject("Address");
		String cityResponse = addr.getString("City");
		String stateResponse = addr.getString("StateProvinceCode");
		
		String zipResponse = addrVal.getString("PostalCodeLowEnd");
		
		
		System.out.println(cityResponse);
		System.out.println(stateResponse);
		System.out.println(zipResponse);
//		String success = addrVal
		
		return false;
	}

	private static boolean validAddress2() throws IOException, JSONException {

		// xav response, street validation

		OkHttpClient client = new OkHttpClient();
		
		String city = "Lombard";
		city = "\"" + city + "\"";
		
		String state = "Illinois";
		state = "\"" + state + "\"";
		
		String zip = "60148";
		zip = "\"" + zip + "\"";
		
		String street = "1741 S Lalonde Ave";
		street = "\"" + street + "\"";
		
		// RequestBody b2 = new RequestBody.create("application/json");

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType,
				"{\r\n\t\"UPSSecurity\": {\r\n\t\t\"UsernameToken\": {\r\n\t\t\t\"Username\": "
				+ "\"attarsaaniya\",\r\n\t\t\t\"Password\": "
				+ "\"Summer2017\"\r\n\t\t},\r\n\t\t\"ServiceAccessToken\": "
				+ "{\r\n\t\t\t\"AccessLicenseNumber\": "
				+ "\"DD33B9ADDD7ADDC8\"\r\n\t\t}\r\n\t},"
				+ "\r\n\t\"XAVRequest\": {\r\n\t\t\"Request\": "
				+ "{\r\n\t\t\t\"RequestOption\": \"1\",\r\n\t\t\t"
				+ "\"TransactionReference\": {\r\n\t\t\t\t\"CustomerContext\":"
				+ " \"Your Customer Context\"\r\n\t\t\t}\r\n\t\t},\r\n\t\t"
				+ "\"MaximumListSize\": \"10\",\r\n\t\t\"AddressKeyFormat\": "
				+ "{\r\n\t\t\t\"ConsigneeName\": \"Consignee Name\",\r\n\t\t\t"
				+ "\"BuildingName\": \"Building Name\",\r\n\t\t\t\"AddressLine\": "
				+ street + ",\r\n\t\t\t\"PoliticalDivision2\": "
				+ city + ",\r\n\t\t\t\"PoliticalDivision1\": "
				+ state + " ,\r\n\t\t\t\"PostcodePrimaryLow\":"
				+ zip + ",\r\n\t\t\t\"CountryCode\": \"US\"\r\n\t\t}\r\n\t}\r\n}");
		
		Request request = new Request.Builder().url("https://onlinetools.ups.com/rest/XAV").post(body).build();

		okhttp3.Response response = client.newCall(request).execute();

		JSONObject jResponse = new JSONObject(response.body().string());
		System.out.println(jResponse);

		JSONObject xavResponse = jResponse.getJSONObject("XAVResponse");
		JSONObject response5 = xavResponse.getJSONObject("Response");
		JSONObject respStatus = response5.getJSONObject("ResponseStatus");
		String desc = respStatus.getString("Description");
		
		// check desc == "Success"
		// check if this matches city/state/zip from other api

		System.out.println(desc);
		JSONObject candidate = xavResponse.getJSONObject("Candidate");
		JSONObject addrKeyFormat = candidate.getJSONObject("AddressKeyFormat");
		String addrResponse = addrKeyFormat.getString("AddressLine");
		String cityResponse = addrKeyFormat.getString("PoliticalDivision2");
		String stateResponse = addrKeyFormat.getString("PoliticalDivision1");
		String zipResponse = addrKeyFormat.getString("PostcodePrimaryLow");
		
		System.out.println(addrResponse);
		System.out.println(cityResponse);
		System.out.println(stateResponse);
		System.out.println(zipResponse);
		return false;
	}

	private static boolean validAddress(String street, String city, String state, String zip) {
		boolean valid = false;

		JSONObject accessNum = new JSONObject();
		try {
			accessNum.put("AccessLicenseNumber", "DD33B9ADDD7ADDC8");

			accessNum.put("UserId", "attarsaaniya");
			accessNum.put("Password", "Summer2017");

			JSONObject addrValReq = new JSONObject();

			JSONObject transRef = new JSONObject();
			transRef.put("CustomerContext", "mycustomer");

			JSONObject req = new JSONObject();
			req.put("TransactionReference", transRef);
			req.put("RequestAction", "AV");

			JSONObject addr = new JSONObject();
			addr.put("City", city);
			addr.put("StateProvinceCode", state);
			addr.put("PostalCode", zip);

			addrValReq.put("Address", addr);
			addrValReq.put("Request", req);

			JSONObject root = new JSONObject();

			root.put("AccessRequest", accessNum);
			root.put("AddressValidationRequest", addrValReq);

			System.out.println(root);

			// validates state.
			String stateURL = "https://wwwcie.ups.com/rest/AV";
			Client c = ClientBuilder.newClient();
			WebTarget tar = c.target(stateURL);

			System.out.println(root);
			Response cResp = tar.request("application/json").post(Entity.json(root.toString()));

			String response = cResp.readEntity(String.class);
			JSONObject j = new JSONObject(response);
			System.out.println(j);

			JSONObject responseJ = j.getJSONObject("AddressValidationResponse");
			JSONObject resp2 = responseJ.getJSONObject("Response");
			String resp3 = (String) resp2.get("ResponseStatusDescription");

			String success = resp3;
			System.out.println("success = " + success);
			// XAVRequest xav = new XAVRequest();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return valid;
	}
}
