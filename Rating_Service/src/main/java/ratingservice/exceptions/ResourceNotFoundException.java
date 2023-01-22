package ratingservice.exceptions;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String userId) {
        super("Rating with given id is not found on server!!");
    }


}
