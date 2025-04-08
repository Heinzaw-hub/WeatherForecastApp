package main.service;

import main.exception.LocationNotFoundException;
import main.exception.WeatherDataException;
import main.model.Forecast;
import main.model.Location;

import java.util.List;

public class WeatherService {

    private final List<Location> locations;
    private final List<Forecast> forecasts;

    public WeatherService(List<Location> locations, List<Forecast> forecasts) {
        this.locations = locations;
        this.forecasts = forecasts;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Forecast getForecast(String locationName) throws LocationNotFoundException {
        for (Forecast forecast : forecasts) {
            if (forecast.getLocationType().contains(locationName)) {
                return forecast;
            }
        }
        throw new LocationNotFoundException("Forecast for " + locationName + " not found.");
    }
}
