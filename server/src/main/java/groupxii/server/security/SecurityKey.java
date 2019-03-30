package groupxii.server.security;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class SecurityKey {
    public static SecurityKey instance = new SecurityKey();

    public final String DEFAULT_FILENAME = "key";
    private byte[] key;

    public void readKey() throws IOException {
	    this.readKey(DEFAULT_FILENAME);
    }

    public void readKey(String filename) throws IOException {
            key = Files.readAllBytes(Paths.get(filename));
    }

    public byte[] getKey() {
        return this.key;
    }
}
