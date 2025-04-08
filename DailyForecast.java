package main.model;

public class DailyForecast implements Forecast {
    private String location;
    private String date;
    private double temperature;
    private String conditions;
    
    public DailyForecast(String location, String date, double temperature, String conditions) {
        this.location = location;
        this.date = date;
        this.temperature = temperature;
        this.conditions = conditions;
    }
    
    /**
     * Implementation of the interface method - demonstrates polymorphism
     * Each forecast type can have its own specific way of describing itself
     */
    @Override
    public String getDescription() {
        return "Daily forecast for " + location + " on " + date;
    }
    
    /**
     * Implementation showing polymorphic behavior - display format specific to daily forecasts
     */
    @Override
    public void display() {
        System.out.println("=== DAILY FORECAST ===");
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Conditions: " + conditions);
        System.out.println("=====================");
    }
    
    @Override
    public String getLocationType() {
        return "DAILY:" + location;
    }
    
    // Getters
    public String getLocation() {
        return location;
    }
    
    public String getDate() {
        return date;
    }
    
    public double getTemperature() {
        return temperature;
    }
    
    public String getConditions() {
        return conditions;
    }
}
