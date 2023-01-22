package ratingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ratingservice.entity.Rating;
import ratingservice.service.RatingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rating")
public class RatingController {

    private final RatingService service;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){

        Rating rating1 = service.saveRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRating(){
        List<Rating> allRating = service.getAllRating();
        return ResponseEntity.ok(allRating);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRatingId(@PathVariable String ratingId){
        Rating rating = service.getRating(ratingId);
        return ResponseEntity.status(HttpStatus.FOUND).body(rating);
    }

    @PutMapping
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating){
        Rating rating1 = service.updateUser(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    @DeleteMapping("/{ratingId}")
    public String deleteRating(@PathVariable String ratingId){
        return service.deleteRating(ratingId);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getUserById(@PathVariable String userId){
        List<Rating> ratingByUserId = service.getRatingByUserId(userId);
        return ResponseEntity.status(HttpStatus.FOUND).body(ratingByUserId);
    }

    @GetMapping("/mobile/{mobileId}")
    public ResponseEntity<List<Rating>> getRatingByMobileId(@PathVariable String mobileId){
        List<Rating> ratingByMobile = service.getRatingByMobile(mobileId);
        return ResponseEntity.ok(ratingByMobile);
    }

}
