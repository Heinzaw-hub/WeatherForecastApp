package main.model;

import java.util.ArrayList;
import java.util.List;

public class WeeklyForecast implements Forecast {
    private String location;
    private String startDate;
    private String endDate;
    private List<DailyForecast> dailyForecasts;
    
    public WeeklyForecast(String location, String startDate, String endDate) {
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dailyForecasts = new ArrayList<>();
    }
    
    /**
     * Demonstrates inheritance/interface implementation with a different behavior
     * than DailyForecast - polymorphism in action
     */
    @Override
    public String getDescription() {
        return "Weekly forecast for " + location + " from " + startDate + " to " + endDate;
    }
    
    @Override
    public void display() {
        System.out.println("=== WEEKLY FORECAST ===");
        System.out.println("Location: " + location);
        System.out.println("Period: " + startDate + " to " + endDate);
        System.out.println("Daily forecasts:");
        
        for (DailyForecast daily : dailyForecasts) {
            System.out.println("  - " + daily.getDate() + ": " + daily.getTemperature() + 
                              "°C, " + daily.getConditions());
        }
        System.out.println("======================");
    }
    
    @Override
    public String getLocationType() {
        return "WEEKLY:" + location;
    }
    
    // Add a daily forecast to
