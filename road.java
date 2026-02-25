import java.util.*;

public class Road {
    //fields
    Station[] stations;

    //constructor
    public Road(int stationCount){
        stations = new Station[stationCount];
        for(int i = 0; i < stationCount; i++){
            stations[i] = new Station();
        }
    }

    //methods

    public void populatePeople(int people){
        for(int i = 0; i < people - 1; i++){
            int station = (int)(Math.random() * stations.length);
            Person person = new Person((int)(Math.random() * stations.length));
            while(person.getEndStation() == station){
                station = (int) (Math.random() * stations.length);
            }
            stations[station].addPassenger(person);
        }
    }

    public void populateCars(int cars){
        for(int i = 0; i < cars; i++){
            int station = (int) (Math.random() * stations.length);
            int endStation = (int) (Math.random() * stations.length);
            while(station == endStation){
                endStation = (int) (Math.random() * stations.length);
            }
            Car car = new Car(station, endStation);
            stations[car.getStat()].takeCar(car);
        }
    }

    public void runRoad(){
        ArrayList<Car> allCars = new ArrayList<Car>();
        for(int i = 0; i < stations.length; i++){
            stations[i].sendPassengers();
            allCars.addAll(stations[i].sendCars());
        }
        for(int i = 0; i < allCars.size(); i++){    
            stations[allCars.get(i).getStat()].takeCar(allCars.get(i));
        }
        for(int i = 0; i < stations.length; i++){
            stations[i].takePassengers();
        }
    }

    public int resetRoad(){
        int totalCompleted = 0;
        for(int i = 0; i < stationCount(); i++){
            totalCompleted += stations[i].completed();
        }
        for(int i = 0; i < stationCount(); i++){
            stations[i].clear();
        }
        return totalCompleted;
    }

    public String toString(){
        String s = "";
        for(Station i : stations){
            s += i.toString();
            s+= "\n__________\n";
        }
        return s;
    }

    public int stationCount(){
        return stations.length;
    }
}
