package com.example.individualproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Top5ActorRepo extends JpaRepository<Film, String> {
    @Query(value = "SELECT actor.actor_id, first_name, last_name, COUNT(*) as movies from actor, film_actor, film where (film.film_id = film_actor.film_id) and (film_actor.actor_id = actor.actor_id) group by actor.actor_id order by COUNT(*) desc LIMIT 5;", nativeQuery = true)
    List<Object[]> getTopFiveActors();
}
