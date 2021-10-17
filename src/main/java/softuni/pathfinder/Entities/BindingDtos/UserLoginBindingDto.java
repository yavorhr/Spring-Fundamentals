package softuni.pathfinder.Entities.BindingDtos;

public class UserLoginBindingDto {

    private String username;
    private String password;

    public UserLoginBindingDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginBindingDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
