package solidLab;

public class PasswordHasher {

    private Encrypt encrypt;

    public PasswordHasher(Encrypt encrypt) {
        this.encrypt = encrypt;
    }

    public String hash(String password) {
        return encrypt.encode(password);
    }

}
