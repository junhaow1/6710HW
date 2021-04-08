package comp1110.homework.C01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RoutePlanner {


    class Location{
        double xCoord;
        double yCoord;

        public Location(double xCoord, double yCoord) {
            this.xCoord = xCoord;
            this.yCoord = yCoord;
        }
    }


    List<Location> locationList = new ArrayList<>();


    public RoutePlanner(List<Location> locationList) {
        this.locationList = locationList;
    }

    public RoutePlanner() {
    }

    public void addLocation(Location location){
        locationList.add(location);
    }

    public double distance (double startX, double startY, double currentX, double currentY){
        return Math.sqrt((startX-currentX)*(startX-currentX) + (startY-currentY)*(startY-currentY));
    }

    public List<Location> calculateRoute(double startX, double startY){

        HashMap<Double, Location> hashmap1 = new HashMap<Double, Location>();
        for (Location location: locationList){
            hashmap1.put(distance(startX,startY,location.xCoord, location.yCoord),location);
        }

        List<Double> doubleList = new ArrayList<>(hashmap1.keySet());
        Collections.sort(doubleList);

        List<Location> locationOutput = new ArrayList<>();
        for (double d: doubleList){
            locationOutput.add(hashmap1.get(d));
        }
        return locationOutput;
    }
}
