package accounts.servers.employee;

import baseurl.BaseURL;
import beans.employee.Employee;
import beans.employee.EmployeeService;
import beans.employee.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/profile")
public class EmployeeProfile extends BaseURL {
    private Employee employee = new Employee(new Employee.EmployeeBuilder());
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        if (UserLoggedIn(req,resp)){
            System.out.println();
            setUpProfile(req, resp);
        }else{
            gotoLoginPage(req,resp);
        }
    }

    private void gotoLoginPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    private void setUpProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        getUserProfileInformation(request,response);
        String url = request.getServletPath() + "/employee.jsp";
        response.sendRedirect(url);

    }

    private void getUserProfileInformation(HttpServletRequest request, HttpServletResponse response) {
        employee = employeeService.getEmployeeData(1);
    }
    
}
