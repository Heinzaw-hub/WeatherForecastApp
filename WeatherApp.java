package main;

import main.exception.LocationNotFoundException;
import main.exception.WeatherDataException;
import main.model.Location;
import main.service.FileService;
import main.service.WeatherService;
import main.model.Forecast;

import java.util.List;
import java.util.Scanner;

public class WeatherApp {

    public static void main(String[] args) {
        String locationFilePath = "resources/locations.txt";
        String forecastsFilePath = "resources/forecasts.txt";
        
        FileService fileService = new FileService();
        WeatherService weatherService = null;

        try {
            List<Location> locations = fileService.readLocations(locationFilePath);
            List<Forecast> forecasts = fileService.readForecasts(forecastsFilePath);
            weatherService = new WeatherService(locations, forecasts);
        } catch (WeatherDataException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Available locations:");
        for (Location location : weatherService.getLocations()) {
            System.out.println(location);
        }

        System.out.print("Enter a location name to get forecast: ");
        String locationName = scanner.nextLine();

        try {
            Forecast forecast = weatherService.getForecast(locationName);
            forecast.display();
        } catch (LocationNotFoundException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
