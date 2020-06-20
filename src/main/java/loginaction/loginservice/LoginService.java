package loginaction.loginservice;

import loginaction.model.loginModel.LoginModel;
import loginaction.model.responselogin.UserLoginResponse;

public interface LoginService {
    UserLoginResponse login(LoginModel loginModel);
    UserLoginResponse getUserObject(LoginModel loginModel);
}
