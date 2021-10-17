package softuni.pathfinder.Services.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.pathfinder.Entities.Enums.LevelEnum;
import softuni.pathfinder.Entities.Models.User;
import softuni.pathfinder.Entities.ServiceDtos.UserLoginServiceDto;
import softuni.pathfinder.Entities.ServiceDtos.UserProfileDto;
import softuni.pathfinder.Entities.ServiceDtos.UserRegisterServiceDto;
import softuni.pathfinder.Repositories.UserRepository;
import softuni.pathfinder.Services.UserService;
import softuni.pathfinder.util.CurrentUser;


@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegisterServiceDto userServiceDto) {

        User user = modelMapper.map(userServiceDto, User.class);
        user.setLevel(LevelEnum.BEGINNER);
        userRepository.save(user);
    }

    @Override
    public UserLoginServiceDto findUserByUserNameAndPassword(String username, String password) {

        return this.userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserLoginServiceDto.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id).setUsername(username);
    }

    @Override
    public void logout() {
        currentUser.setUsername(null).setId(null);
    }

    @Override
    public UserProfileDto findUserById(Long id) {
        return this.userRepository
                .findUserById(id)
                .map(user -> modelMapper.map(user, UserProfileDto.class))
                .orElse(null);
    }

    @Override
    public boolean doesUsernameAlreadyExist(String username) {
        return this.userRepository.findUserByUsername(username).isPresent();
    }

}
