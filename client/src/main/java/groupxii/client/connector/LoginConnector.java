package groupxii.client.connector;

public class LoginConnector {
	public static String postCredentials(String reqBody) {
		String resource = "/login";

		return Connector.postRequest(resource, reqBody);
	}
}
