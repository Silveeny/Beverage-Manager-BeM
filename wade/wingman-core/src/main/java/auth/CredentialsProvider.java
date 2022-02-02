package auth;

public interface CredentialsProvider {
    boolean isValidAuth(String user, String password);
}
