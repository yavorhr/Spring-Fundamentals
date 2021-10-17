package softuni.pathfinder.Entities.ServiceDtos;

import softuni.pathfinder.Entities.Enums.LevelEnum;

public class UserProfileDto {

    private Long id;
    private String fullName;
    private Integer age;
    private String username;
    private LevelEnum level;

    public UserProfileDto() {
    }

    public Long getId() {
        return id;
    }

    public UserProfileDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserProfileDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserProfileDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserProfileDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public UserProfileDto setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }
}
