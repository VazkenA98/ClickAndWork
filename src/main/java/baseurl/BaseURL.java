package baseurl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebListener
public class BaseURL extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals("GET")) {
            doGet(req, resp);
        } else if (req.getMethod().equals("POST")) {
            doPost(req, resp);
        }
        super.service(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestUrl = request.getServletPath();
        if (requestUrl.startsWith("/user")) {
            checkUserCookie();
        } else if (requestUrl.startsWith("/business")) {
            checkBusinessCookie();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestUrl = request.getServletPath();
        if (requestUrl.startsWith("/user")) {
            checkUserCookie();
        } else if (requestUrl.startsWith("/business")) {
            checkBusinessCookie();
        }
    }
    private void checkBusinessCookie() {
    }

    private void checkUserCookie() {
    }


    protected boolean UserLoggedIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();

        if (cookies == null || cookies.length < 1) {
            response.sendRedirect("/login");
        }

        String cookieName = "cookieUserRole";
        for (Cookie cookie : cookies) {

            if (cookieName.equals(cookie.getName())) {
                return true;
            }
        }
        return false;
    }
}