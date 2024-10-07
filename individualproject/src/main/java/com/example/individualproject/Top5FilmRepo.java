package com.example.individualproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Top5FilmRepo extends JpaRepository<Film, String> {
    @Query(value = "SELECT film.film_id, title, film.description, film.length, rating, COUNT(*) as rented, name from  inventory, film, rental, film_category, category  where (rental.inventory_id = inventory.inventory_id) and (inventory.film_id = film.film_id) and (film.film_id = film_category.film_id) and (film_category.category_id = category.category_id) group by film.film_id, film.title, film.description, film.length, film.rating, category.name order by COUNT(*) desc LIMIT 5;", nativeQuery = true)
    List<Object[]> getTopFive();
}

//@Repository
//public interface TopActorFilms extends JpaRepository<Film, String>{
//    @Query(value = "", nativeQuery = true);
//    List<Object[]> getTopActorFilms();
//}
