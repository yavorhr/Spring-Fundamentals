package softuni.pathfinder.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.pathfinder.Entities.Models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

  Optional<User> findByUsernameAndPassword(String username, String password);

  Optional<User> findUserById(Long id);

  Optional <User> findUserByUsername(String username);
}
