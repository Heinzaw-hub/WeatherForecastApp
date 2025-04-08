package main.exception;

// Custom exception for when a location is not found
public class LocationNotFoundException extends Exception {
    public LocationNotFoundException(String message) {
        super(message);
    }
}
