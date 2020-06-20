package loginaction.model.loginModel;

public class LoginModel {

    private final String username;
    private final String password;

    public LoginModel(LoginModelBuilder loginModelBuilder) {
        this.username = loginModelBuilder.username;
        this.password = loginModelBuilder.password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static class LoginModelBuilder{
        private String username;
        private String password;

        public LoginModelBuilder username(String username){
            this.username = username;
            return this;
        }

        public LoginModelBuilder password(String password){
            this.password = password;
            return this;
        }

        public LoginModel build(){
            return new LoginModel(this);
        }
    }
}
