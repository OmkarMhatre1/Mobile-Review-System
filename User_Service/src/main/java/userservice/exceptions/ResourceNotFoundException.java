package userservice.exceptions;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String userId) {
        super("UserName with given id is not found on server!!");
    }


}
