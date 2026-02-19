import java.util.*;

public class Station {
    //fields
    private ArrayList<Person> peopleWaiting;
    private ArrayList<Person> peopleCompleted;
    private ArrayList<Car> carsWaiting;
    private ArrayList<Car> carsCompleted;
    private static int id = 0;
    private int myId;

    //constructor
    
    public Station(){
        peopleWaiting = new ArrayList<Person>();
        peopleCompleted = new ArrayList<Person>();
        carsWaiting = new ArrayList<Car>();
        carsCompleted = new ArrayList<Car>();
        myId = id;
        id++;
    }

    //methods
    public void takePassengers(){
        ArrayList<Person> arrivals;
        for(int i = 0; i < carsWaiting.size(); i++){
            arrivals = carsWaiting.get(i).dropPassenger();
            for(int j = 0; j < arrivals.size() j++){
                if(arrivals.get(j).getStation() == myId){
                    peopleCompleted.add(arrivals.get(j));
                }
                else{
                    peopleWaiting.add(arrivals.get(j));
                }
            }
        }
    }

    
}

