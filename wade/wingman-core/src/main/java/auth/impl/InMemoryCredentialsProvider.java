package auth.impl;

import auth.CredentialsProvider;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCredentialsProvider implements CredentialsProvider {

    final Map<String, String> credentials = new HashMap<String, String>() {
        {
            put("admin", "123");
            put("silvan", "123");
            put("bogdan", "123");
        }
    };


    @Override
    public boolean isValidAuth(String user, String password) {

        for (Map.Entry<String, String> entry : credentials.entrySet()) {
            if (entry.getKey().equals(user) && entry.getValue().equals(password)) {
                return true;
            }

        }
        return false;
    }
}
