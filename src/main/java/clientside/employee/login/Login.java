package clientside.employee.login;

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
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        login(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
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
        String url = request.getServletPath()+"/";
        response.sendRedirect(url);
    }
}
