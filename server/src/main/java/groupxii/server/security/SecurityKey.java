package groupxii.server.security;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Reades a file to be used as private security key when signing tokens.
 */
public final class SecurityKey {
    public static SecurityKey instance = new SecurityKey();

    public final String defaultFilename = "key"; // Fuck Checkstyle :-)
    private byte[] key;

    public void readKey() throws IOException {
        this.readKey(defaultFilename);
    }

    public void readKey(String filename) throws IOException {
        key = Files.readAllBytes(Paths.get(filename));
    }

    public byte[] getKey() {
        return this.key;
    }
}
