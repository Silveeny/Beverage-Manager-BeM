package cache;

import redis.clients.jedis.JedisPooled;

import java.sql.Time;

public class QueryCacher {
    public static void cacheQuery(String user, String query) {
        System.out.println("Caching username: " + user);
        System.out.println("Caching password: " + user);

        JedisPooled jedis = new JedisPooled("host.docker.internal", 6379);
        jedis.set(user, query);
    }
}
