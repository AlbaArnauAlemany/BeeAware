package ch.unil.doplab.beeaware.domain;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.ComponentFilter;
import com.google.maps.model.GeocodingResult;
import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.util.Scanner;


public class Location {
    private static final String APIKEY = "AIzaSyB5qyPPrL8MtoN0ifPtyUA2IQdGHAF43Mw";

    private String locationID;
    private double latitude;
    private double longitude;

    public Location(String locationID) throws ApiException, InterruptedException, IOException {
        this.locationID = locationID;
        setCoordinates();
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

    public String getLocationID() {
        return locationID;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public static void main(String[] args) {
        try {
            Location location = new Location("test_2");
            System.out.println("Location ID: " + location.getLocationID());
            System.out.println("Latitude: " + location.getLatitude());
            System.out.println("Longitude: " + location.getLongitude());
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}

