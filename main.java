package main.model;

public interface Forecast {
    /**
     * Using an interface here is a good design decision because:
     * 1. It allows us to define a contract for different types of forecasts
     * 2. We can easily add new forecast types without modifying existing code (Open/Closed Principle)
     * 3. It enables polymorphism - we can treat different forecast types uniformly
     */
    String getDescription();
    void display();
    String getLocationType();
}
