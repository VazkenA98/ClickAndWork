package loginaction.model.loginModel;

public class LoginModel {

    private final String username;
    private final String password;
    private final String roll;

    public LoginModel(LoginModelBuilder loginModelBuilder) {
        this.username = loginModelBuilder.username;
        this.password = loginModelBuilder.password;
        this.roll = loginModelBuilder.roll;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRoll() {
        return roll;
    }

    public static class LoginModelBuilder{
        private String username;
        private String password;
        private String roll;

        public LoginModelBuilder username(String username){
            this.username = username;
            return this;
        }

        public LoginModelBuilder password(String password){
            this.password = password;
            return this;
        }
        public LoginModelBuilder roll(String roll){
            this.roll = roll;
            return this;
        }


        public LoginModel build(){
            return new LoginModel(this);
        }
    }
}
