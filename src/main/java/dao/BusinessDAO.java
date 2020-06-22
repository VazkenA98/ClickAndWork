package dao;

import loginaction.model.loginModel.LoginModel;
import loginaction.model.responselogin.UserLoginResponse;
import models.Role;

public class BusinessDAO {
    public static UserLoginResponse checkBusinessInput(LoginModel loginModel) {

        return   new UserLoginResponse.UserLoginResponseBuilder()
                .firstName("6-20-2020")
                .lastName("skhayalian@gmail.com")
                .id(12)
                .role(new Role("BUSINESS_ROLE"))
                .build();
    }
}
