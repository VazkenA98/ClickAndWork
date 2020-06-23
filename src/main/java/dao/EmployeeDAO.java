package dao;

import beans.employee.Employee;
import loginaction.model.loginModel.LoginModel;
import loginaction.model.responselogin.UserLoginResponse;
import models.Role;

public class EmployeeDAO {

    public static UserLoginResponse checkEmployeeInput(LoginModel loginModel) {

        return   new UserLoginResponse.UserLoginResponseBuilder()
                .id(1)
                .firstName("vazken")
                .role(new Role("EMPLOYEE_ROLE"))
                .build();
    }


    public Employee getEmployeeData(int id) {
        // select query where is from userobject = ?

        if(id == 1)
            return new Employee.EmployeeBuilder()
                    .firstName("vazken")
                    .lastName("abdulian")
                    .id(1)
                    .role(new Role("EMPLOYEE_ROLE"))
                    .date("1998-09-13")
                    .mail("vazken99@gmail.com")
                    .build();
        return null;

    }
}
