package softuni.pathfinder.Entities.BindingDtos;

import javax.validation.constraints.Email;

public class UserRegisterBindingDto {

    private String username;
    private String fullName;
    private String email;
    private Integer age;
    private String password;
    private String confirmPassword;

    public UserRegisterBindingDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegisterBindingDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
