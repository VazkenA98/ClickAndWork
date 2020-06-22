package dao;

import loginaction.model.loginModel.LoginModel;
import loginaction.model.responselogin.UserLoginResponse;
import models.Role;

public class EmployeeDAO {

    public static UserLoginResponse checkEmployeeInput(LoginModel loginModel) {

        return   new UserLoginResponse.UserLoginResponseBuilder()
                .firstName("6-20-2020")
                .lastName("vazken@gmail.com")
                .id(12)
                .role(new Role("EMPLOYEE_ROLE"))
                .build();
    }

}
