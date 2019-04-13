package groupxii.client;

/**
 * Holds the verification token and periodically updates it from the server.
 */

public class TokenManager {
	public static TokenManager instance;
	/**
	 * Holds the JSON request to be posted on login.
	 */
	private String loginReqBody;

	/**
	 * Holds the JWT from the server.
	 */
	private String jwt;

	/**
	 * The daemon timeout should roughly match the validty of the token.
	 * TODO read the validity off the token.
	 */
	public final static int timeout = 86390000;

	public TokenManager(String username, String password) {
		jwt = null;

		loginReqBody = "{"
			+ "\"username\":"
			+ "\"" + username + "\", "
			+"\"password\":"
			+ "\"" + password + "\"}";
		//TODO hash+salt the password

		Thread daemon = new Thread(new Daemon());
		daemon.setDaemon(true);
		daemon.start();
	}

	/**
	 * Returns the currently held JWT
	 */
	public String getToken() {
		return this.jwt;
	}

	class Daemon implements Runnable {
		/**
		 * Periodically requests a new token from the server.
		 * Should be a daemon thread.
		 */
		public void run() {
			while (true) {
				refreshToken();

				try {
					Thread.sleep(timeout);
				} catch (InterruptedException e) {
					//Die
					break;
				}
			}
		}
	}


	public void refreshToken() {
		//TODO
		//Connector.postLogin(reqBody) or something
		//Store that response in jwt
	}
}
