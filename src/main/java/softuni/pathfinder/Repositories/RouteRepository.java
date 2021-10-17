package softuni.pathfinder.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.pathfinder.Entities.Models.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
}
