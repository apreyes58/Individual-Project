package com.example.individualproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmSearchRepo extends JpaRepository<Film, String> {
    @Query(value = "SELECT film.film_id, title, description, length, rating, name as category, COUNT(rental_id), GROUP_CONCAT(distinct CONCAT(actor.first_name, ' ', actor.last_name) SEPARATOR ', ') AS actors from film, film_category, category, film_actor, actor, inventory, rental where (film.film_id = film_category.film_id) and (film_category.category_id = category.category_id) and (film_actor.film_id = film.film_id) and (film_actor.actor_id = actor.actor_id) and (inventory.film_id = film.film_id) and (rental.inventory_id = inventory.inventory_id) group by film.film_id, film.title, category.name;", nativeQuery = true)
    List<Object[]> getFilmSearch();
}
