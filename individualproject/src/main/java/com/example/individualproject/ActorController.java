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
@RequestMapping("/api/actors")
public class ActorController {
    @Autowired
    private ActorService service;   

    @GetMapping("/top5")
    public ResponseEntity<List<Actor>> getTopFive() {
        List<Actor> actors = service.topFive();
        return ResponseEntity.ok(actors);
    }

}
