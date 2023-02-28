package solidLab;

import java.util.Base64;

public class PasswordDecoder {

    public String decode(String hash) {
        return new String(Base64.getEncoder().encode(hash.getBytes()));
    }

}
