package clientside.employee.auth;

import baseurl.BaseURL;
import cookiemanagment.CookieController;
import loginaction.loginactionloginserviceimpl.LoginServiceImpl;
import loginaction.model.loginModel.LoginModel;
import loginaction.model.responselogin.UserLoginResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorization")
public class UserAuthorization extends BaseURL {
    private LoginModel loginModel = new LoginModel(new LoginModel.LoginModelBuilder());
    private UserLoginResponse userObject = new UserLoginResponse(new UserLoginResponse.UserLoginResponseBuilder());
    private LoginServiceImpl loginService = new LoginServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        userAuthorization(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    private void userAuthorization(HttpServletRequest request, HttpServletResponse response) throws IOException {
        getParameters(request,response);
        checkUserInputs(loginModel,request,response);
    }

    private void checkUserInputs(LoginModel loginModel,HttpServletRequest request, HttpServletResponse response) throws IOException {
        userObject = loginService.login(loginModel);
        if(null == userObject){
            //TODO: send error message "login or oassword envalide
        }else{
            CookieController.createCookieAndSessionsUser(userObject, request, response);
            response.sendRedirect("/login/logout.jsp");
        }

    }

    private void getParameters(HttpServletRequest request, HttpServletResponse response) {
        loginModel = new LoginModel.LoginModelBuilder()
                .username(request.getParameter("email"))
                .password(request.getParameter("password"))
                .build();
        System.out.println();
    }
}
