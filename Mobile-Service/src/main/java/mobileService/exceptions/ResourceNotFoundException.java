package mobileService.exceptions;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String userId) {
        super("Mobile with given id is not found on server!!");
    }


}
