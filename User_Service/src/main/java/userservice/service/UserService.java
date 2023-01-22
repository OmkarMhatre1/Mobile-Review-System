package userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import userservice.entity.Mobile;
import userservice.entity.Rating;
import userservice.entity.User;
import userservice.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    //    WebClient.Builder  builder= WebClient.builder();
    private final RestTemplate restTemplate;


    public List<User> getAllUser() {
        List<User> users = repository.findAll();
        return users;

    }

    public User getUser(String userId) {
        User user = repository.findById(userId).orElseThrow(() -> new RuntimeException(userId));

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/rating/user/" + user.getUserId(), Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        //Api call to Mobile service to get Mobile
        //set mobile to rating
        //return the rating

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //Api call to Mobile service to get Mobile
            //http://localhost:8082/mobile
            ResponseEntity<Mobile> forEntity = restTemplate.getForEntity("http://MOBILE-SERVICE/mobile/" + rating.getMobileId(), Mobile.class);

            Mobile mobile = forEntity.getBody();
            //set mobile to rating
            rating.setMobile(mobile);
            //return the rating
            return rating;
        }).collect(Collectors.toList());

        //return user and set in the ratings
        user.setRating(ratings);
        return user;
    }

    public User saveUser(User user) {
        return repository.save(user);
    }


    public User updateUser(User user) {
        User user1 = repository.findById(user.getUserId()).orElse(null);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setNumber(user.getNumber());

        return repository.save(user1);
    }

    public String deleteUser(String userId) {
        repository.deleteById(userId);
        return "User Deleted" + userId;
    }


}
