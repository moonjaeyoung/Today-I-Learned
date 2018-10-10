package util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Hyunwoong
 * @When : 2018-10-09 오후 10:00
 * @Homepage : https://github.com/gusdnd852
 */
public class UserData {
    private Map<String, String> user;
    private static UserData singleton = null;

    public static UserData get() {
        if (singleton == null) singleton = new UserData();
        return singleton;
    }

    private UserData() {
        user = new HashMap<>();
    }

    public Map<String, String> getUser() {
        return user;
    }

    public void SignUp(String id, String password) {
        user.put(id, password);
    }
}
