package userservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userservice.entity.User;
import userservice.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User user1 = service.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping
    public ResponseEntity<List<User>> getListOfUser() {
        List<User> allUser = service.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "Breaker", fallbackMethod = "ratingMobileFallback")
    public ResponseEntity<User> getUserId(@PathVariable String userId) {
        User user = service.getUser(userId);
        return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }

    //fallback method using circuit breaker

//    public ResponseEntity<User> ratingMobileFallback(String userId, Exception ex){
//        User user = User.builder()
//                .firstName("Dummy User")
//                .lastName("Dummy User")
//                .email("Dummy email")
//                .number("000")
//                .userId("adad")
//                .build();
//        return ResponseEntity.status(HttpStatus.FOUND).body(user);
//    }


    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User user1 = service.updateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return service.deleteUser(userId);
    }

}
