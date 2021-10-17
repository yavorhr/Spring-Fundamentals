package softuni.pathfinder.Services;


import softuni.pathfinder.Entities.ServiceDtos.UserLoginServiceDto;
import softuni.pathfinder.Entities.ServiceDtos.UserProfileDto;
import softuni.pathfinder.Entities.ServiceDtos.UserRegisterServiceDto;


public interface UserService {
    void registerUser(UserRegisterServiceDto user);

    UserLoginServiceDto findUserByUserNameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logout();

    UserProfileDto findUserById(Long id);

    boolean doesUsernameAlreadyExist(String username);
}
