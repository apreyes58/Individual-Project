package com.example.individualproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/films")
public class FilmController {
    @Autowired
    private FilmService service;

    @GetMapping("/top5")
    public ResponseEntity<List<Film>> getTopFive() {
        List<Film> films = service.topFive();
        return ResponseEntity.ok(films);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Film>> getSearch() {
        List<Film> films = service.getSearch();
        return ResponseEntity.ok(films);
    }

}
