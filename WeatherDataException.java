package main.exception;

// Custom exception for weather data issues
public class WeatherDataException extends Exception {
    public WeatherDataException(String message) {
        super(message);
    }
}
