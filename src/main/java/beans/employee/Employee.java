package beans.employee;

import loginaction.model.responselogin.UserLoginResponse;
import models.Role;

public class Employee{
    private final int id;
    private final String firstName;
    private final String lastName;
    private final Role role;
    private final String date;
    private final String mail;

    public Employee(Employee.EmployeeBuilder employeeBuilder) {
        this.id = employeeBuilder.id;
        this.firstName = employeeBuilder.firstName;
        this.lastName = employeeBuilder.lastName;
        this.role = employeeBuilder.role;
        this.date = employeeBuilder.date;
        this.mail = employeeBuilder.mail;
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

    public Role getRole() {
        return role;
    }

    public String getDate() {
        return date;
    }

    public String getMail() {
        return mail;
    }

    public static class EmployeeBuilder {
        private int id;
        private String firstName;
        private String lastName;
        private Role role;
        private String date;
        private String mail;

        public Employee.EmployeeBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public Employee.EmployeeBuilder id(int id) {
            this.id = id;
            return this;
        }

        public Employee.EmployeeBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Employee.EmployeeBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Employee.EmployeeBuilder date(String date) {
            this.date = date;
            return this;
        }
        public Employee.EmployeeBuilder mail(String mail) {
            this.mail = mail;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

    }

}
