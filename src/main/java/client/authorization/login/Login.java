package client.authorization.login;

import baseurl.BaseURL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends BaseURL {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
        if (UserLoggedIn(request,response)){
            System.out.println();
            login(request, response);
        }else{
            gotoLoginPage(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }
    //TODO: first check if user already logged in
    //TODO: if user not logged in request send to login page
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        gotoLoginPage(request,response);
    }

    private void gotoLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = "/user/profile";
        response.sendRedirect(url);
    }
}
