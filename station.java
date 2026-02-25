import java.util.*;

public class Station {
    //fields
    private ArrayList<Person> peopleWaitingRight;
    private ArrayList<Person> peopleWaitingLeft;
    private ArrayList<Person> peopleCompleted;
    private ArrayList<Car> carsWaiting;
    private ArrayList<Car> carsCompleted;
    private static int id = 0;
    private int myId;

    //constructor
    
    /**
     * The constructor for the Station class
     */
    public Station(){
        peopleWaitingRight = new ArrayList<Person>();
        peopleWaitingLeft = new ArrayList<Person>();
        peopleCompleted = new ArrayList<Person>();
        carsWaiting = new ArrayList<Car>();
        carsCompleted = new ArrayList<Car>();
        myId = id;
        id++;
    }

    //methods
    /**
     * Loops through all the cars and calls dropPassenger on them.
     * People are sorted into peopleWaitingRight, peopleWaitingLeft, and peopleCompleted based on the current station and their ending station.
     * Cars are also sorted into carsCompleted if they have reached their destination.
     */
    public void takePassengers(){
        ArrayList<Person> arrivals;
        for(int i = carsWaiting.size() - 1; i > -1; i--){
            arrivals = carsWaiting.get(i).dropPassenger();
            for(int j = 0; j < arrivals.size(); j++){
                if(arrivals.get(j).getEndStation() == myId){
                    peopleCompleted.add(arrivals.get(j));
                }
                else{
                    if(arrivals.get(j).getEndStation() - myId > 0){
                        peopleWaitingRight.add(arrivals.get(j));
                    }
                    else{
                        peopleWaitingLeft.add(arrivals.get(j));
                    }
                }
            }
            if(carsWaiting.get(i).getEndStat() == myId){
                carsCompleted.add(carsWaiting.get(i));
                carsWaiting.remove(i);
            }
        }
    }

    /**
     * Loops through all the cars and calls addPassenger on them. The people added are going in the same direction as the car
     */
    public void sendPassengers(){
        for(int i = 0; i < carsWaiting.size(); i++){
            ArrayList<Person> loading = new ArrayList<Person>();
            int capacity = 3 - carsWaiting.get(i).getLoad();
            int loadAmount;
            if(carsWaiting.get(i).getDir() == 1 && !peopleWaitingRight.isEmpty()){
                loadAmount = Math.min(peopleWaitingRight.size(), capacity);
                for(int j = 0; j < loadAmount; j++){
                    loading.add(peopleWaitingRight.get(j));
                }
                for(int j = 0; j < loadAmount; j++){
                    peopleWaitingRight.remove(0);
                }
            }

            if(carsWaiting.get(i).getDir() == -1 && !peopleWaitingLeft.isEmpty()){
                loadAmount = Math.min(peopleWaitingLeft.size(), capacity);
                for(int j = 0; j < loadAmount; j++){
                    loading.add(peopleWaitingLeft.get(j));
                }
                for(int j = 0; j < loadAmount; j++){
                    peopleWaitingLeft.remove(0);
                }
            }
            if(!loading.isEmpty()){
                carsWaiting.get(i).addPassenger(loading);
            }
            carsWaiting.get(i).move();
        }
    }

    /**
     * Removes all cars from the station
     * @return List of cars that were in the station before removal
     */
    public ArrayList<Car> sendCars(){
        ArrayList<Car> sentCars = (ArrayList) carsWaiting.clone();
        carsWaiting.clear();
        return sentCars;
    }

    /**
     * The station adds all incoming cars to carsWaiting
     * @param incCars ArrayList of incoming cars
     */
    public void takeCars(ArrayList<Car> incCars){
        carsWaiting.clear();
        carsWaiting.addAll(incCars);
    }

    /**
     * The station adds a singular car to carsWaiting.
     * Used for populateCars.
     * @param car incoming car
     */
    public void takeCar(Car car){
        carsWaiting.add(car);
    }

    /**
     * The station accepts a singular person and sorts them.
     * Used for populatePeople.
     * @param person person added to the station
     */
    public void addPassenger(Person person){
        if(person.getEndStation() - myId > 0){
            peopleWaitingRight.add(person);
            }
        else{
            peopleWaitingLeft.add(person);
            }
    }

    /**
     * Clears the station by removing everything from all lists.
     */
    public void clear(){
        peopleWaitingLeft.clear();
        peopleWaitingRight.clear();
        peopleCompleted.clear();
        carsWaiting.clear();
        carsCompleted.clear();
    }

    /**
     * Returns amount of people that have ended their journy at this station.
     * @return peopleCompleted.size()
     */
    public int completed(){
        return peopleCompleted.size();
    }

    public String toString(){
        String s = "Station: " + myId + "\nPeople Waiting Left:";
        for(Person p : peopleWaitingLeft){
            s += "(" + p + ")";
        }

        s += "\nPeople Waiting Right: ";
        for(Person p : peopleWaitingRight){
            s += "(" + p + ")";
        }
        s += "\nPeople Finished: ";
        for(Person p : peopleCompleted){
            s += "(" + p + ")";
        }

        s += "\nCars Waiting: ";
        for(Car c : carsWaiting){
            s += "(" + c + ")";
        }

        s += "\nCars Finished: ";
        for(Car c : carsCompleted){
            s += "(" + c + ")";
        }

        return s;
    }
}

    


