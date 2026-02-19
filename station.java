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


    
}

