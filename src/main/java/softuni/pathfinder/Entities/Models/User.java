package softuni.pathfinder.Entities.Models;

import softuni.pathfinder.Entities.Enums.LevelEnum;
import softuni.pathfinder.Entities.Enums.RoleEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    private Integer age;
    @Column(nullable = false)
    private String fullName;
    @Enumerated(EnumType.STRING)
    private LevelEnum level;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,unique = true)
    private String username;
    private String email;

    @ManyToMany(fetch =FetchType.EAGER )
    private Set<Role> role;

    public User() {
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public User setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<Role> getRole() {
        return role;
    }

    public User setRole(Set<Role> role) {
        this.role = role;
        return this;
    }
}
