package auth;

import auth.impl.InMemoryCredentialsProvider;

public class AuthManager {
    final static CredentialsProvider credentials = new InMemoryCredentialsProvider();

    public static boolean authenticate(String user, String password) {
        return credentials.isValidAuth(user, password);
    }

}
