package ch.unil.doplab.beeaware.Domain;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.ComponentFilter;
import com.google.maps.model.GeocodingResult;
import com.google.maps.errors.ApiException;
import lombok.*;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ResourceBundle;

//import static ch.unil.doplab.beeaware.Utilis.addLocation;

/**
 * Represents a geographical location, defined by its latitude, longitude, country,
 * and NPA code. This class uses the Google Geocoding API to obtain latitude
 * and longitude coordinates based on NPA and country information.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    // ResourceBundle is a Java class for loading locale-specific resources
    private Long id;            // Unique identifier for the {@code Location}
    private String country;     // Country of the {@code Location}
    private int NPA;            // NPA code of the {@code Location}
    private Coordinate coordinate;

    /**
     * Constructs a Location object using the specified National Postal Area (NPA) and country.
     * It then initializes the coordinates by fetching them from the Google Geocoding API.
     *
     * @param NPA The NPA code for the {@code Location}.
     * @param country The country associated with the {@code Location}.
     * @throws ApiException If the API encounters an error while processing the request.
     * @throws InterruptedException If the API request is interrupted.
     * @throws IOException If an input or output exception occurs.
     */
    public Location(int NPA, String country, Coordinate coordinate){
        this.NPA = NPA;
        this.country = country;
        this.coordinate = coordinate;   // Method to set the latitude and longitude based on NPA and country
    }

    public Location(int NPA, String country){
        this.NPA = NPA;
        this.country = country;
    }
}

