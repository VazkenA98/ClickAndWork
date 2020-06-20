package loginaction.model.responselogin;

import models.Role;

public class UserLoginResponse {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final Role role;

    public UserLoginResponse(UserLoginResponseBuilder userLoginResponseBuilder) {
        this.id = userLoginResponseBuilder.id;
        this.firstName = userLoginResponseBuilder.firstName;
        this.lastName = userLoginResponseBuilder.lastName;
        this.role = userLoginResponseBuilder.role;
    }

    public Role getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class UserLoginResponseBuilder {
        private int id;
        private String firstName;
        private String lastName;
        private Role role;

        public UserLoginResponseBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public UserLoginResponseBuilder id(int id) {
            this.id = id;
            return this;
        }

        public UserLoginResponseBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserLoginResponseBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserLoginResponse build() {
            return new UserLoginResponse(this);
        }

    }

}
