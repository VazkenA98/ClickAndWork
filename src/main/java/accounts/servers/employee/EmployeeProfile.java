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

@WebServlet("/EmployeeProfile")
public class EmployeeProfile extends BaseURL {
    private Employee employee = new Employee(new Employee.EmployeeBuilder());
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        setUpProfile(req, resp);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void setUpProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        getUserProfileInformation(request,response);
        response.sendRedirect("/accounts/employee.jsp");

    }

    private void getUserProfileInformation(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) request.getAttribute("id");
        employee = employeeService.getEmployeeData(id);
    }
    
}
