package jp.co.jedis;

import java.util.UUID;

import redis.clients.jedis.Jedis;

public class UserAction {
	private static final int TIMEOUT = 30*60;
    public static void main(String[] args) {
        String userToken = UUID.randomUUID().toString();
        System.out.println("key: " + userToken);
        Jedis jedis = new Jedis("localhost");
        User user = new  User("tanaka", "Tokyo-shibuya");
        //30分後、無効になる
        jedis.setex(userToken, TIMEOUT, user.toString());
        jedis.close();
        System.out.println("保存が成功しました。");

    }

}
