package cookiemanagment;

import loginaction.model.responselogin.UserLoginResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieController {

    //adding cookies and sessions for the users
    public static void createCookieAndSessionsUser(UserLoginResponse userObject, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie;
        String roleName = String.valueOf(userObject.getRole().getRole());
        if (roleName.contentEquals("EMPLOYEE_ROLE")) {
            cookie = new Cookie("cookieUserRole", createCookieString(userObject));
        } else {
            cookie = new Cookie("cookieBusinessRole", createCookieString(userObject));
        }
        cookie.setMaxAge(20 * 20 * 60);
        request.getSession().setAttribute("userId", userObject.getId());
        response.addCookie(cookie);
    }

    //removing cookies and sessions for the users
    public static void removeCookieAndSessions(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if ("cookieUserRole".equals(cookie.getName())) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    request.getSession().setAttribute("userId", null);
                    request.getSession().removeAttribute("userId");
                    request.getSession().invalidate();
                }
            }
        }
    }

    public static void IsUserLoggedIn(UserLoginResponse userObject,HttpServletRequest request, HttpServletResponse response) {

    }

    public boolean userRole(UserLoginResponse userObject,HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    private static String createCookieString(UserLoginResponse userLoginResponse) {
        return userLoginResponse.getFirstName() + userLoginResponse.getLastName() + userLoginResponse.getId();
    }
}