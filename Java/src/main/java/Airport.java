import planes.ExperimentalPlane;
import planes.types.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return planes.stream().filter(o -> o instanceof PassengerPlane).map(o -> (PassengerPlane) o).collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream().filter(o -> o instanceof MilitaryPlane).map(o -> (MilitaryPlane) o).collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream().filter(o -> o instanceof ExperimentalPlane).map(o -> (ExperimentalPlane) o).collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return getPassengerPlanes().stream().max(Comparator.comparingInt(PassengerPlane::getPassengersCapacity)).orElse(null);
    }

    public List<MilitaryPlane> getMilitaryPlanes(MilitaryType militaryType) {
        return getMilitaryPlanes().stream().filter(o -> o.getMilitaryType() == militaryType).collect(Collectors.toList());
    }

    public void sortByMaxFlightDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
    }

    public void sortByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
    }

    public void sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public void print() {
        planes.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes +
                '}';
    }
}
