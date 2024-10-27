package ch.unil.doplab.beeaware.Domain;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.ComponentFilter;
import com.google.maps.model.GeocodingResult;
import com.google.maps.errors.ApiException;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import static ch.unil.doplab.beeaware.Utilis.addLocation;

@Getter
@Setter
public class Location {
    private static final String APIKEY = ResourceBundle.getBundle("application").getString("API_KEY");
    private static long idNumber = 0;
    private Long id;
    private double latitude;
    private double longitude;
    private String country;
    private int NPA;
    private static Set<Location> Locations = new HashSet<>();

    public Location(int NPA, String country) throws ApiException, InterruptedException, IOException {
        this.NPA = NPA;
        this.country = country;
        addLocation(this);
        setCoordinates(this);
    }

    private static GeoApiContext getGeoApiContext() {
        return new GeoApiContext.Builder()
                .apiKey(APIKEY)
                .build();
    }

    private static double[] getCoordinates(GeoApiContext context, Location location) throws ApiException, InterruptedException, IOException {
        GeocodingResult result = GeocodingApi.geocode(context, String.valueOf(location.NPA)).components(ComponentFilter.country(location.country)).language("fr").await()[0];
        double lat = Math.round(result.geometry.location.lat * 100000.0) / 100000.0;
        double lng = Math.round(result.geometry.location.lng * 100000.0) / 100000.0;

        return new double[]{lat, lng};
    }

    private void setCoordinates(Location location) throws ApiException, InterruptedException, IOException {
        double[]  coordinates = getCoordinates(getGeoApiContext(), location);
        this.latitude = coordinates[0];
        this.longitude = coordinates[1];
    }
}

