package com.example.battleships_exam.repository;

import com.example.battleships_exam.model.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {

  Optional<CategoryRepository> findByName(String name);

  List<Ship> findAllByUserId(Long user_id);

  @Query("SELECT s from Ship s WHERE s.user.id <> :id")
  List<Ship> findOtherShips(@Param("id") Long id);
}
