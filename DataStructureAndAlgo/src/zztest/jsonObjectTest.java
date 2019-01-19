package zztest;

import org.json.JSONObject;

public class jsonObjectTest {

	public static void main(String[] args) {
		String response = "{\"status\":\"SUCCESS\",\"code\":\"200\",\"errorNodeType\":null,\"error_id\":null,\"errorCode\":null,\"message\":\"\",\"description\":\"\",\"version\":null,\"data\":{\"patients\":{\"validatePref\":{\"sessionId\":\"8EwrIAnAWE7EE7EEoEO77E7AAA7kEA8A\",\"isUserEnrolledInMscriptsAutoFill\":\"1\",\"patientPortalToken\":\"dummyToken\"}}}}";
		try {
			if (null != response) {
				JSONObject responseJson = new JSONObject(response);// below line
				String isUserEnrolledInMscriptsAutoFill = !responseJson.getJSONObject("data").getJSONObject("patients")
						.getJSONObject("validatePref").get("isUserEnrolledInMscriptsAutoFill").equals(null)
								? ((String) responseJson.getJSONObject("data").getJSONObject("patients")
										.getJSONObject("validatePref").get("isUserEnrolledInMscriptsAutoFill"))
								: null;
				String patientPortalToken = !responseJson.getJSONObject("data").getJSONObject("patients")
						.getJSONObject("validatePref").get("patientPortalToken").equals(null)
								? ((String) responseJson.getJSONObject("data").getJSONObject("patients")
										.getJSONObject("validatePref").get("patientPortalToken"))
								: null;
				// session.setAttribute("token", patientPortalToken);
				String alertMessage = !responseJson.get("message").equals(null) ? (String) responseJson.get("message")
						: null;

				// if exception is thrown by API, skip further processing.
				if (alertMessage != null || ("".equalsIgnoreCase(alertMessage))) {
					String errorCode = null;
					if ("0".equalsIgnoreCase(isUserEnrolledInMscriptsAutoFill)) {
						// ECOH709
						errorCode = "ECOH709";
						alertMessage = "You do not have any Rx in autofill program.";
						// overriding response returned by API, as API is
						// used in different scenarios in different
						// applications.
						response = "{ \"status\": \"FAILURE\", \"code\": \"201\", "
								+ "\"errorNodeType\": \"ALERT\", \"error_id\": \"1\", \"errorCode\": \"" + errorCode
								+ "\", \"message\": \"" + alertMessage
								+ "\", \"description\": null,  \"version\": null, \"data\": null}";
						responseJson = new JSONObject(response);
					} else {
						if ("dummyToken".equalsIgnoreCase(patientPortalToken)) {
							// ECOH710
							errorCode = "ECOH710";
							alertMessage = "Your autofill Rx pickup dates cannot be adjusted now, as you are not close to next pickup date.";
							// overriding response returned by API, as API
							// is used in different scenarios in different
							// applications.
							response = "{ \"status\": \"FAILURE\", \"code\": \"201\", "
									+ "\"errorNodeType\": \"ALERT\", \"error_id\": \"1\", \"errorCode\": \"" + errorCode
									+ "\", \"message\": \"" + alertMessage
									+ "\", \"description\": null,  \"version\": null, \"data\": null}";
							responseJson = new JSONObject(response);
						}
					}
				}
			}
			aaa();
		} catch (Exception ex) {

			ex.printStackTrace();
		}
		System.out.println(response);
	}
public static Integer aaa(){
	return 1;
}
}
