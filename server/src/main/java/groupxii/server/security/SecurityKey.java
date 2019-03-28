package groupxii.server.security;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class SecurityKey {
    public static SecurityKey instance = new SecurityKey();

    private byte[] key;
    private String filename = "key";

    SecurityKey() {
        try {
            key = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            key = null;
        }
    }


    public byte[] getKey() {
        return this.key;
    }
}
