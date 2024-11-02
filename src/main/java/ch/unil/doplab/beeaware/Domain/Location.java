package ch.unil.doplab.beeaware.Domain;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.ComponentFilter;
import com.google.maps.model.GeocodingResult;
import com.google.maps.errors.ApiException;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ResourceBundle;

//import static ch.unil.doplab.beeaware.Utilis.addLocation;

/**
 * Represents a geographical location, defined by its latitude, longitude, country,
 * and NPA code. This class uses the Google Geocoding API to obtain latitude
 * and longitude coordinates based on NPA and country information.
 */

@Getter
@Setter
public class Location {
    // ResourceBundle is a Java class for loading locale-specific resources
    private static final String APIKEY = ResourceBundle // API key for Google Geocoding API
            .getBundle("application")
            .getString("API_KEY");
    private Long id;            // Unique identifier for the {@code Location}
    private double latitude;    // Latitude of the {@code Location}
    private double longitude;   // Longitude of the {@code Location}
    private String country;     // Country of the {@code Location}
    private int NPA;            // NPA code of the {@code Location}

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
    public Location(int NPA, String country) throws ApiException, InterruptedException, IOException {
        this.NPA = NPA;
        this.country = country;
        setCoordinates(this);   // Method to set the latitude and longitude based on NPA and country
    }

    /**
     * Creates and configures a GeoApiContext object to use the Google Geocoding API.
     *
     * @return A configured GeoApiContext instance with the API key.
     */
    private static GeoApiContext getGeoApiContext() {
        return new GeoApiContext.Builder()
                .apiKey(APIKEY)
                .build();
    }

    /**
     * Retrieves the latitude and longitude coordinates for a specified location using
     * the Google Geocoding API.
     *
     * @param context The GeoApiContext to use for the API request.
     * @param location The {@code Location} for which coordinates are being retrieved.
     * @return An array containing the latitude and longitude of the {@code Location}.
     * @throws ApiException If the API encounters an error while processing the request.
     * @throws InterruptedException If the API request is interrupted.
     * @throws IOException If an input or output exception occurs.
     */
    @NotNull
    private static double[] getCoordinates(GeoApiContext context, @NotNull Location location)
            throws ApiException, InterruptedException, IOException {
        GeocodingResult result = GeocodingApi
                .geocode(context, String.valueOf(location.NPA))
                .components(ComponentFilter.country(location.country))
                .language("fr")
                .await()[0];
        double lat = Math.round(result.geometry.location.lat * 100000.0) / 100000.0;
        double lng = Math.round(result.geometry.location.lng * 100000.0) / 100000.0;

        return new double[]{lat, lng};
    }

    /**
     * Sets the latitude and longitude of this {@code Location} instance by fetching coordinates
     * through {@link #getCoordinates(GeoApiContext, Location)}
     * using the Google Geocoding API based on the {@code Location} NPA and country.
     *
     * @param location The {@code Location} instance for which coordinates are being set.
     * @throws ApiException If the API encounters an error while processing the request.
     * @throws InterruptedException If the API request is interrupted.
     * @throws IOException If an input or output exception occurs.
     */
    private void setCoordinates(Location location) throws ApiException, InterruptedException, IOException {
        double[]  coordinates = getCoordinates(getGeoApiContext(), location);
        this.latitude = coordinates[0];
        this.longitude = coordinates[1];
    }
}

