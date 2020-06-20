package loginaction.loginactionloginserviceimpl;

import dao.LoginDao;
import loginaction.loginservice.LoginService;
import loginaction.model.loginModel.LoginModel;
import loginaction.model.responselogin.UserLoginResponse;

public class LoginServiceImpl implements LoginService {

    private LoginDao loginDao = new LoginDao();
    @Override
    public UserLoginResponse login(LoginModel loginModel) {
        return loginDao.checkUserInput(loginModel);
    }

    @Override
    public UserLoginResponse getUserObject(LoginModel loginModel) {
        return loginDao.getUserObject(loginModel);
    }
}
