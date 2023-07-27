package login;

import jakarta.servlet.http.Cookie;

public class Auth {
    String[] idList = { "tanaka", "saitou", "katou" };
    String[] pwList = { "1111", "2222", "3333" };
    boolean isAuth(String id, String pw) {
        if (id == null || pw == null) {
            return false;
        }
        for (int i = 0; i < idList.length; i++) {
            if (id.equals(idList[i]) && pw.equals(pwList[i])) {
                return true;
            }
        }
        return false;
    }

    boolean loggedIn(Cookie cookie) {
        if (cookie == null) return false;
        if (cookie.getName().equals("stamp")) {
            return cookie.getValue().equals("1234");
        }
        return false;
    }
}
