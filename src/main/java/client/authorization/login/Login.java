package client.authorization.login;

import baseurl.BaseURL;
import beans.employee.EmployeeService;
import dao.AdminDAO;
import dao.EmployeeDAO;
import dao.Services.EmployeeDaoService;
import hibernate.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        /*String url = "/user/profile";
        response.sendRedirect(url);*/
        System.out.println("going to hibernate dao");
        EmployeeDaoService service = new EmployeeDaoService();
        System.out.println(service.findById(1));

       // AdminDAO.getAllAdminInfo();

        String url = request.getServletPath()+"/";
        response.sendRedirect(url);
    }
}
