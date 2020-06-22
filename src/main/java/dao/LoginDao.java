package dao;

import loginaction.model.loginModel.LoginModel;
import loginaction.model.responselogin.UserLoginResponse;
import models.Role;

public class LoginDao {

    public UserLoginResponse checkUserInput(LoginModel loginModel) {
        System.out.println(loginModel.getPassword() + " " + loginModel.getUsername());
        UserLoginResponse userLoginResponse = null;
        if(loginModel.getRoll().equals("EMPLOYEE_ROLE")){
            // access employee query
            userLoginResponse = EmployeeDAO.checkEmployeeInput(loginModel);
        }else if(loginModel.getRoll().equals("BUSINESS_ROLE")){
            // access business query
            userLoginResponse = BusinessDAO.checkBusinessInput(loginModel);
        }else{

        }
        return userLoginResponse;
    }


    public UserLoginResponse getUserObject(LoginModel loginModel) {
        return null;
    }
}
