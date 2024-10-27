package com.example.individualproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Top5ActorRepo extends JpaRepository<Film, String> {
    @Query(value = "SELECT actor.actor_id, actor.first_name, actor.last_name, COUNT(film_actor.film_id) AS movies, (SELECT GROUP_CONCAT(top_films.title ORDER BY top_films.rental_count DESC SEPARATOR ', ') FROM (SELECT film.title, COUNT(rental.rental_id) AS rental_count FROM film_actor AS fa JOIN film ON fa.film_id = film.film_id JOIN inventory ON film.film_id = inventory.film_id JOIN rental ON inventory.inventory_id = rental.inventory_id WHERE fa.actor_id = actor.actor_id GROUP BY film.title ORDER BY rental_count DESC LIMIT 5) AS top_films) AS top_movies FROM actor JOIN film_actor ON actor.actor_id = film_actor.actor_id GROUP BY actor.actor_id ORDER BY movies DESC LIMIT 5;", nativeQuery = true)
    List<Object[]> getTopFiveActors();
}
