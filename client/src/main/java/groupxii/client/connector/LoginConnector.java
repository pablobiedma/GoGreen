package groupxii.client.connector;

public class LoginConnector {
    public static String postCredentials(String reqBody) {
        String resource = "/login";

        return Connector.postRequest(resource, reqBody);
    }

    public static String register(String username, String password) {
        String resource = "/register"
            + "?" + username
            + "&" + password;

        return Connector.postRequest(resource);
    }
}
