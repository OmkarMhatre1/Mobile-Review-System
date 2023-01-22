package ratingservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ratingservice.entity.Rating;
import ratingservice.repository.RatingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository repository;

    public List<Rating> getAllRating() {
        return repository.findAll();
    }

    public Rating getRating(String ratingId) {
        Rating rating = repository.findById(ratingId).orElseThrow(() -> new RuntimeException(ratingId));
        return rating;
    }

    public Rating saveRating(Rating rating) {
        return repository.save(rating);
    }


    public Rating updateUser(Rating rating) {
        Rating rating1 = repository.findById(rating.getRatingId()).orElse(null);
        rating1.setStars(rating.getStars());
        rating1.setPros(rating.getPros());
        rating1.setCons(rating.getCons());

        return repository.save(rating1);
    }

    public String deleteRating(String ratingId){
        repository.deleteById(ratingId);
        return "Rating Deleted"+ratingId;
    }

    public List<Rating> getRatingByUserId(String userId){
        return repository.findByUserId(userId);
    }

    public List<Rating> getRatingByMobile(String mobileId){
        return repository.findByMobileId(mobileId);
    }


}
