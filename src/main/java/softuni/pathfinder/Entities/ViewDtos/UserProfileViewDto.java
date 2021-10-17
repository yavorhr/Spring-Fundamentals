package softuni.pathfinder.Entities.ViewDtos;
import softuni.pathfinder.Entities.Enums.LevelEnum;

public class UserProfileViewDto {

    private Long id;
    private String fullName;
    private Integer age;
    private String username;
    private LevelEnum level;

    public UserProfileViewDto() {
    }

    public Long getId() {
        return id;
    }

    public UserProfileViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserProfileViewDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserProfileViewDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserProfileViewDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public UserProfileViewDto setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }
}
