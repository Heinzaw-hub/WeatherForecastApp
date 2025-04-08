package main.service;

import main.exception.WeatherDataException;
import main.model.DailyForecast;
import main.model.Location;
import main.model.WeeklyForecast;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    // Method to read locations from file
    public List<Location> readLocations(String filePath) throws WeatherDataException {
        List<Location> locations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Location location = new Location(parts[0], parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
                    locations.add(location);
                }
            }
        } catch (IOException e) {
            throw new WeatherDataException("Error reading locations from file: " + e.getMessage());
        }
        return locations;
    }

    // Method to read forecasts from file
    public List<Forecast> readForecasts(String filePath) throws WeatherDataException {
        List<Forecast> forecasts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            WeeklyForecast currentWeeklyForecast = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if ("DAILY".equals(parts[0]) && parts.length == 5) {
                    DailyForecast daily = new DailyForecast(parts[1], parts[2], Double.parseDouble(parts[3]), parts[4]);
                    forecasts.add(daily);
                    
                    if (currentWeeklyForecast != null) {
                        currentWeeklyForecast.addDailyForecast(daily);
                    }
                } else if ("WEEKLY".equals(parts[0]) && parts.length == 4) {
                    currentWeeklyForecast = new WeeklyForecast(parts[1], parts[2], parts[3]);
                    forecasts.add(currentWeeklyForecast);
                }
            }
        } catch (IOException e) {
            throw new WeatherDataException("Error reading forecasts from file: " + e.getMessage());
        }
        return forecasts;
    }
}
