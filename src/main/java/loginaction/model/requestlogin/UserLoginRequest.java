package loginaction.model.requestlogin;

public class UserLoginRequest {
    private final String email;
    private final String password;
    private final int status;
    private final String socialToken;

    public UserLoginRequest(UserLoginRequestBuilder userLoginRequestBuilder) {
        this.email = userLoginRequestBuilder.email;
        this.password = userLoginRequestBuilder.password;
        this.status = userLoginRequestBuilder.status;
        this.socialToken = userLoginRequestBuilder.socialToken;
    }

    public String getEmail() {
        return email;
    }

    public int getStatus() {
        return status;
    }

    public String getSocialToken() {
        return socialToken;
    }

    public String getPassword() {
        return password;
    }

    public static class UserLoginRequestBuilder {
        private String email;
        private String password;
        private int status;
        private String socialToken;

        public UserLoginRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserLoginRequestBuilder status(int status) {
            this.status = status;
            return this;
        }

        public UserLoginRequestBuilder socialToken(String socialToken) {
            this.socialToken = socialToken;
            return this;
        }

        public UserLoginRequest build() {
            return new UserLoginRequest(this);
        }
    }
}
