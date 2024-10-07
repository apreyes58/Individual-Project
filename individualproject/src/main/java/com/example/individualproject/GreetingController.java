package com.example.individualproject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class GreetingController {
    @GetMapping("/add")
    public ResponseEntity<Integer> addNumbers() {
        int result = 3 + 1;
        return ResponseEntity.ok(result);
    }
}