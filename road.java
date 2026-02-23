import java.util.*;

public class Road {
    //fields
    Station[] stations;

    //constructor
    public Road(){
        stations = new Station[4];
        for(int i = 0; i < 4; i++){
            stations[i] = new Station();
        }
    }

    //methods

    public void populatePeople(int people){
        for(int i = 0; i < people - 1; i++){
            int station = (int)(Math.random() * 4);
            Person person = new Person((int)(Math.random() * 4));
            while(person.getStation() == station){
                person.changeEndStation((int)(Math.random() * 4));
            }
            stations[station].addPassenger(person);
        }
    }

    public void populateCars(int cars){
        for(int i = 0; i < cars; i++){
            Car car = new Car((int)(Math.random() * 4), (int)(Math.random() * 4));
            if(car.getEndStat() == car.getStat()){
                car.changeEndStation((int)(Math.random() * 4));
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
}
