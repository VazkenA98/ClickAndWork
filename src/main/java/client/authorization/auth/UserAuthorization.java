package client.authorization.auth;

import baseurl.BaseURL;
import beans.employee.Employee;
import beans.employee.EmployeeService;
import beans.employee.EmployeeServiceImpl;
import cookiemanagment.CookieController;
import dao.EmployeeDAO;
import loginaction.loginactionloginserviceimpl.LoginServiceImpl;
import loginaction.model.loginModel.LoginModel;
import loginaction.model.responselogin.UserLoginResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorization")
public class UserAuthorization extends HttpServlet {
    private LoginModel loginModel = new LoginModel(new LoginModel.LoginModelBuilder());
    private UserLoginResponse userObject = new UserLoginResponse(new UserLoginResponse.UserLoginResponseBuilder());
    private LoginServiceImpl loginService = new LoginServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userAuthorization(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userAuthorization(request,response);
    }

    private void userAuthorization(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getParameters(request, response);
        checkUserInputs(loginModel, request, response);
    }

    private void checkUserInputs(LoginModel loginModel, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        userObject = loginService.login(loginModel);
        if (null == userObject) {
            //TODO: send error message "login or password invalide
        } else {
            CookieController.createCookieAndSessionsUser(userObject, request, response);
            redirectAccountDashboard(userObject, request, response);

        }

    }

    private void redirectAccountDashboard(UserLoginResponse userObject, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getStatus();

        if (userObject.getRole().getRole().equals("EMPLOYEE_ROLE")) {
            response.sendRedirect("/user/profile");
        } else if (userObject.getRole().getRole().equals("BUSINESS_ROLE")) {

        } else {

        }
    }


    private void getParameters(HttpServletRequest request, HttpServletResponse response) {
        loginModel = new LoginModel.LoginModelBuilder()
                .username(request.getParameter("email"))
                .password(request.getParameter("password"))
                .roll((request.getParameter("roll")))
                .build();
        System.out.println();
    }
}
