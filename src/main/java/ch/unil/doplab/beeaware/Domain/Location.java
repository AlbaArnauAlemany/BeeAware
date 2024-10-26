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
import java.util.Scanner;
import java.util.Set;

@Getter
@Setter
public class Location {
    private static final String APIKEY = ResourceBundle.getBundle("application").getString("API_KEY");
    private static long idNumber = 0;
    private Long id;
    private double latitude;
    private double longitude;
    private short NPA;
    private static Set<Location> Locations = new HashSet<>();


    public Location() throws ApiException, InterruptedException, IOException {
        this.id = idNumber++;
        setCoordinates();
    }

    public Location(Short NPA) throws ApiException, InterruptedException, IOException {
        this();
        this.NPA = NPA;
    }

    private static GeoApiContext getGeoApiContext() {
        return new GeoApiContext.Builder()
                .apiKey(APIKEY)
                .build();
    }

    private static double[] getCoordinates(GeoApiContext context) throws ApiException, InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please entre your NPA and/or locality.");
        String adr = scanner.nextLine();
        GeocodingResult result = GeocodingApi.geocode(context, adr).components(ComponentFilter.country("CH")).language("fr").await()[0];
        double lat = Math.round(result.geometry.location.lat * 100000.0) / 100000.0;
        double lng = Math.round(result.geometry.location.lng * 100000.0) / 100000.0;

        return new double[]{lat, lng};
    }

    private void setCoordinates() throws ApiException, InterruptedException, IOException {
        double[]  coordinates = getCoordinates(getGeoApiContext());
        this.latitude = coordinates[0];
        this.longitude = coordinates[1];
    }

//    public void addLocation(Location location){
//        for (Location loc: Locations) {
//            if (lo != null && bee.username != null && beezzer.getUsername() == bee.username) {
//                throw new IllegalArgumentException("Username " + username + " already used. Please try a new one.");
//            }
//        }
//        Beezzers.add(beezzer);
//    }
}

