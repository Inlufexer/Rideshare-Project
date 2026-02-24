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
            while(person.getStation() == station){
                person.changeEndStation((int)(Math.random() * stations.length));
            }
            stations[station].addPassenger(person);
        }
    }

    public void populateCars(int cars){
        for(int i = 0; i < cars; i++){
            Car car = new Car((int)(Math.random() * stations.length), (int)(Math.random() * stations.length));
            while(car.getEndStat() == car.getStat()){
                car.changeEndStation((int)(Math.random() * stations.length));
            }
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
