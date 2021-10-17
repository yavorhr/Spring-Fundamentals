package softuni.pathfinder.Entities.ServiceDtos;

import softuni.pathfinder.Entities.Enums.LevelEnum;
import softuni.pathfinder.Entities.Models.Role;

import java.util.Set;

public class UserRegisterServiceDto {

    private String username;
    private String fullName;
    private String email;
    private Integer age;
    private String password;
    private LevelEnum level;
    private Set<Role> roles;

    public UserRegisterServiceDto() {
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public UserRegisterServiceDto setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterServiceDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterServiceDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterServiceDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegisterServiceDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterServiceDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public UserRegisterServiceDto setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }
}
