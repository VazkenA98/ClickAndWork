package beans.employee;

import dao.EmployeeDAO;
import dao.LoginDao;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public Employee getEmployeeData(int id) {
        return employeeDAO.getEmployeeData(id);
    }
}
