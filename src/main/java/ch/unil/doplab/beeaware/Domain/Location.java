package ch.unil.doplab.beeaware.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.maps.errors.ApiException;
import jakarta.persistence.*;
import lombok.*;

import java.io.IOException;

/**
 * Represents a geographical location, defined by its latitude, longitude, country,
 * and NPA code. This class needs the Google Geocoding API service in our BeeAware Service
 * to obtain latitude and longitude coordinates based on NPA and country information.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    @Id
    @Column(name= "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            // Unique identifier for the {@code Location}
    @Column(name = "COUNTRY")
    private String country;     // Country of the {@code Location}
    @JsonProperty("NPA")
    @Column(name = "NPA")
    private int NPA; // NPA code of the {@code Location}
    @Column(name = "COORDINATE")
    private Coordinate coordinate;
    @Column(name = "CITYNAME")
    private String cityName;

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
        this.coordinate = coordinate;
    }

    public Location(int NPA, String country){
        this.NPA = NPA;
        this.country = country;
    }
}

