package softuni.pathfinder.Entities.ServiceDtos;

public class UserLoginServiceDto {

    private String username;
    private String password;
    private Long id;

    public UserLoginServiceDto() {
    }

    public Long getId() {
        return id;
    }

    public UserLoginServiceDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserLoginServiceDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginServiceDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
