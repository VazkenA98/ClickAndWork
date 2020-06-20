package dao;

import loginaction.model.loginModel.LoginModel;
import loginaction.model.responselogin.UserLoginResponse;
import models.Role;

public class LoginDao {

    public UserLoginResponse checkUserInput(LoginModel loginModel) {
        System.out.println(loginModel.getPassword() + " " + loginModel.getUsername());
        return new UserLoginResponse.UserLoginResponseBuilder()
                .firstName("6-20-2020")
                .lastName("skhayalian@gmail.com")
                .id(12)
                .role(new Role("EMPLOYEE_ROLE"))
                .build();
    }

    public UserLoginResponse getUserObject(LoginModel loginModel) {
        return null;
    }
}
